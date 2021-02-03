package controller;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.SegmentDao;
import model.Segment;
import model.Step;

public class SegmentController {

	private SegmentDao segmentDao;

	private static SegmentController instance;

	public static SegmentController getInstance() {
		if (instance == null)
			instance = new SegmentController();
		return instance;
	}

	private SegmentController() {
		segmentDao = new SegmentDao(Segment.class);
	}
	
	
	public Segment getSegment(long l) {
		return segmentDao.find(l);
		
	}

	public Segment add(String src, String dst) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		// TODO Auto-generated method stub
		return segmentDao.add(src,dst);
	}
	
	public void delete(long id) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		// TODO Auto-generated method stub
		segmentDao.delete(id);
	}

	public List<Segment> findAll() {
		// TODO Auto-generated method stub
		return segmentDao.findAll();
	}
}