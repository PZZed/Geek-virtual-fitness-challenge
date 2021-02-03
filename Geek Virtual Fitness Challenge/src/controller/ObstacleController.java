package controller;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ObstacleDao;
import model.Checkpoint;

public class ObstacleController {
	private static ObstacleController instance;
	private ObstacleDao dao;
	private ObstacleController() {
		dao = new ObstacleDao();
		System.out.println(dao);
	}
	
	public static ObstacleController getInstance() {
		if(instance == null)
			instance = new ObstacleController();
		return instance;
	}
	
	public List<Checkpoint> findAll(){
		return dao.findAll();
	}

	public Checkpoint create(String name, String action) {
		try {
			return dao.create(new Checkpoint(name, action));
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			return null;
		}
	}
}
