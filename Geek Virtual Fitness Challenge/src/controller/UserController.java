package controller;

import java.util.List;

import dao.UserDao;
import model.User;

public class UserController {

	private UserDao userDao;

	private static UserController instance;

	public static UserController getInstance() {
		if (instance == null)
			instance = new UserController();
		return instance;
	}

	private UserController() {
		userDao = new UserDao(User.class);
	}

	public List<User> findAll() {
		return userDao.findAll();
	}

	public User getUser(int id) {
		return userDao.find(id);
	}
	

	
	public List<User> getUser(String username, String password) {
		return userDao.getUser(username, password);

	}

	public User create(String username, String password, String mail) {
		User res = new User(username, password, mail);
		return userDao.create(res);
	}

	public void changePassword(int id, String password) {
		User updated = getUser(id);
		updated.setPassword(password);
		userDao.edit(updated);
	}

	public void delete(int id) {
		User user = getUser(id);
		userDao.remove(user);
	}

	public void getRoles(int id) {

	}
}
