package controller;

import java.util.List;

import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ObstacleDao;
import dao.SegmentDao;
import dao.StepDao;
import model.Checkpoint;
import model.Segment;
import model.Step;

public class SegmentController {
	private static SegmentController instance;
	private StepDao stepdao;
	private SegmentDao dao;
	private ObstacleDao obstacleDao;

	private SegmentController() {
		dao = new SegmentDao();
		obstacleDao = new ObstacleDao();
		stepdao = new StepDao();
	}

	public static SegmentController getInstance() {
		if (instance == null)
			instance = new SegmentController();
		return instance;
	}

	public Segment getById(long id) {
		return dao.find(id);
	}

	public Segment addObstacle(long id, long idObstacle) {
		Segment seg = dao.find(id);
		Checkpoint obstacle = obstacleDao.find(idObstacle);
		seg.getObstacles().add(obstacle);
		try {
			dao.edit(seg);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
		return seg;
	}

	public List<Segment> getAllStep() {
		return dao.findAll();
	}

	public Segment getSegment(int id) {
		return dao.find(id);

	}

	public Segment add(String src, String dst)
			throws SecurityException, IllegalStateException, NamingException, NotSupportedException, SystemException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		return dao.add(src, dst);
	}

	public List<Segment> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	public Segment create(int src, int dst) {
		Step source = stepdao.find(src);
		Step dest = stepdao.find(dst);
		Segment seg = new Segment(source,dest,null);
		try {
			return dao.create(seg);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
