package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.Segment;
import model.Step;

public class SegmentDao extends DAOAbstractFacade<Segment> {

	public SegmentDao(Class<Segment> classeEntite) {
		super(classeEntite);
		// TODO Auto-generated constructor stub
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
		
		Segment res = new Segment(steps.get(0).getId(),steps.get(1).getId(), 0);
		//System.out.println(res);
		
		return create(res);
		
		
	}
	
	public void delete(long id) {
		Segment rem = find(id);
		System.out.println(rem);
		remove(rem);
		
		
	}

}
