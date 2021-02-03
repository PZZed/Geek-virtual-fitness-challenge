package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import model.Segment;
import model.Step;

public class SegmentDao extends DAOAbstractFacade<Segment> {

	public SegmentDao() {
		super(Segment.class);
	}

	
	
	
	
	public Segment add(String src, String dst) {
		EntityManager em = getEntityManager();
		CriteriaQuery<Step> cq = em.getCriteriaBuilder().createQuery(Step.class);
		Root<Step> rt = cq.from(Step.class);
		cq.select(rt);
		
		cq.where(getEntityManager().getCriteriaBuilder().or(
				getEntityManager().getCriteriaBuilder().equal(rt.get("name"), src),
				getEntityManager().getCriteriaBuilder().equal(rt.get("name"), dst)
				));
		
		Query q = getEntityManager().createQuery(cq);
		
		//em.close();
		 List<Step> steps = q.getResultList();
		System.out.println("---------------------------------");
		System.out.println(steps);
		
		Segment res = new Segment(steps.get(0),steps.get(1), null);
		//System.out.println(res);
		
		try {
			return create(res);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void delete(long id) throws SecurityException, IllegalStateException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		Segment rem = find(id);
		System.out.println(rem);
		remove(rem);
		
		
	}

}
