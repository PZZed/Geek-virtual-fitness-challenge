package controller;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ChallengeDao;
import dao.UserDao;
import model.Challenge;
import model.Roles;
import model.User;

public class UserController {

	private UserDao userDao;
	private ChallengeDao challDao;

	private static UserController instance;

	public static UserController getInstance() {
		if (instance == null)
			instance = new UserController();
		return instance;
	}

	private UserController() {
		userDao = new UserDao();
		challDao = new ChallengeDao();
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User getUser(long id) {
		return userDao.find(id);
	}

	public User create(String username, String password, String mail) {
		User res = new User(username, password, mail, Roles.USER, null);
		try {
			return userDao.create(res);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void changePassword(long id, String password) {
		User updated = getUser(id);
		updated.setPassword(password);
		try {
			userDao.edit(updated);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	public User promote(long id) {
		User updated = getUser(id);
		updated.setRole(Roles.ADMIN);
		try {
			userDao.edit(updated);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}

	public void delete(long id) {
		User user = getUser(id);
		if (user != null)
			try {
				userDao.remove(user);
			} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public List<Challenge> getRegisteredChallenge(long id) {
		User user = getUser(id);
		return user.getRegisteredChallenge();
	}

	public void subscribeChallenge(long id, long idChall) {
		User user = getUser(id);
		if (user != null) {
			Challenge chall = challDao.find(idChall);
			List<Challenge> registerd = user.getRegisteredChallenge();
			registerd.add(chall);
			user.setRegisteredChallenge(registerd);
			try {
				userDao.edit(user);
			} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException
					| RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
				e.printStackTrace();
			}
		}

	}

	public boolean login(String username, String password) {
		List<User> users = findAll();
		/**/
		System.out.println(users.get(0).getClass());
		for (User u : users) {
			if(u.getUsername().equals(username)&&u.getPassword().equals(password))
				return true;
		}
		// java.lang.ClassCastException: class model.User cannot be cast to class
		// model.User (model.User is in unnamed module of loader
		// org.glassfish.web.loader.WebappClassLoader @69643b9f; model.User is in
		// unnamed module of loader org.glassfish.web.loader.WebappClassLoader
		// @71405902)

		return false;
	}

}
