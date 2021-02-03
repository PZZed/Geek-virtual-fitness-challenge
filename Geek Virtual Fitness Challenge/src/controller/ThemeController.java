package controller;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ThemeDao;
import model.Theme;

public class ThemeController {

	
	
	private static ThemeController instance;
	
	private ThemeDao dao;
	
	private ThemeController() {
		dao = new ThemeDao();
	}

	
	
	public static ThemeController getInstance() {
		if (instance == null)
			instance = new ThemeController();
		return instance;
	}
	
	public Theme create(String desc) {
		Theme t = new Theme(desc,0);
		try {
			return dao.create(t);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
		return null;
	}


	public Theme vote(long id) {
		Theme t = dao.find(id);
		t.setNbVote(t.getNbVote()+1);
		try {
			dao.edit(t);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
		return t;
	}

	public List<Theme> getAll() {
		return dao.findAll();
	}
}
