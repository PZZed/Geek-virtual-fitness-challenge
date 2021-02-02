package controller;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.StepDao;
import dao.UserDao;
import model.Step;
import model.User;

public class StepController {

	private StepDao stepDao;

	private static StepController instance;

	public static StepController getInstance() {
		if (instance == null)
			instance = new StepController();
		return instance;
	}

	private StepController() {
		stepDao = new StepDao(Step.class);
	}
	
	public List<Step> getAllStep(){
		return stepDao.findAll();
	}
	
	public Step getStep(int id) {
		return stepDao.find(id);
		
	}

	public Step add(Step step) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		// TODO Auto-generated method stub
		return stepDao.add(step);
	}

	public List<Step> findAll() {
		// TODO Auto-generated method stub
		return stepDao.findAll();
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		stepDao.remove(getStep(id));
	}
}
