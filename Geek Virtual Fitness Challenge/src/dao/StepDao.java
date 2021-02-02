package dao;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import model.Step;


public class StepDao extends DAOAbstractFacade<Step> {

	public StepDao(Class<Step> classeEntite) {
		super(classeEntite);
		// TODO Auto-generated constructor stub
	}

	public Step add(Step step) throws SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException  {
		// TODO Auto-generated method stub
		System.out.println(step);
		create(step);
		
		//getEntityManager().createNativeQuery("Insert into step values("+step.getName()+");", Step.class).executeUpdate();
		//getEntityManager().createQuery("Insert into step values("+step.getName()+");", Step.class).executeUpdate();
		return step;
	}
	

}
