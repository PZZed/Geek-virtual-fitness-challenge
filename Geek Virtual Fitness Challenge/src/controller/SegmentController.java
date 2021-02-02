package controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ObstacleDao;
import dao.SegmentDao;
import model.Checkpoint;
import model.Segment;

public class SegmentController {
	private static SegmentController instance;

	private SegmentDao dao;
	private ObstacleDao obstacleDao;

	private SegmentController() {
		dao = new SegmentDao();
		obstacleDao = new ObstacleDao();
	}

	public static SegmentController getInstance() {
		if (instance == null)
			instance = new SegmentController();
		return instance;
	}

	public Segment getById(long id) {
		return dao.find(id);
	}

	public Segment addObstacle(long id, List<Long> ids) {
		Segment seg = dao.find(id);
		List<Checkpoint> obstacles = new ArrayList<Checkpoint>();
		for (Long i : ids) {
			Checkpoint obstacle = obstacleDao.find(i);
			if (obstacle != null) {
				obstacles.add(obstacle);
			}
		}
		List<Checkpoint> checkPoints = seg.getObstacles();
		checkPoints.addAll(obstacles);
		seg.setObstacles(checkPoints);
		return seg;
	}
	
	public List<Segment> getAllStep(){
		return dao.findAll();
	}
	
	public Segment getSegment(int id) {
		return dao.find(id);
		
	}

	public Segment add(String src, String dst) throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		// TODO Auto-generated method stub
		return dao.add(src,dst);
	}

	public List<Segment> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
}
