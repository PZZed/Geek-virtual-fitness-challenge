package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.User;

public class UserDao extends DAOAbstractFacade<User> {

	public UserDao(Class<User> classeEntite) {
		super(classeEntite);
	}

	public List<User> getUser(String username, String password) {
		//EntityManager em = Persistence.createEntityManagerFactory("gvfc").createEntityManager();
		EntityManager em = getEntityManager();
		CriteriaQuery<User> cq = em.getCriteriaBuilder().createQuery(User.class);
		Root<User> rt = cq.from(User.class);
		cq.select(rt);
		
		cq.where(getEntityManager().getCriteriaBuilder().equal(rt.get("username"), username),getEntityManager().getCriteriaBuilder().equal(rt.get("password"), password));
		//cq.where(getEntityManager().getCriteriaBuilder().equal(rt.get("password"), password));
		Query q = getEntityManager().createQuery(cq);
		
		//em.close();
		return  q.getResultList();

	}

	public String getusername() {
		return (String) getEntityManager().createNativeQuery("SELECT username FROM User", User.class).getSingleResult();
	}
}
