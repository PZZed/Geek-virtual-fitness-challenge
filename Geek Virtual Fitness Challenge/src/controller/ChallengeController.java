package controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import dao.ChallengeDao;
import dao.SegmentDao;
import model.Challenge;
import model.Mode;
import model.Segment;

public class ChallengeController {

	private static ChallengeController instance;

	public static ChallengeController getInstance() {
		if (instance == null)
			instance = new ChallengeController();
		return instance;
	}

	private ChallengeDao dao;
	private SegmentDao segDao;

	private ChallengeController() {
		dao = new ChallengeDao();
		segDao = new SegmentDao();
	}

	public List<Challenge> getAll() {
		return dao.findAll();
	}

	public Challenge getById(long id) {
		return dao.find(id);
	}

	public Challenge create(String name, Mode mode, int maxPlayer, String desc, List<Integer> segmentsIds, String url) {

		// récupérer tout les segments a partir de leur ids
		List<Segment> seg = new ArrayList<Segment>();
		for (Integer id : segmentsIds) {
			seg.add(segDao.find(id));
		}

		// création du challenge
		Challenge chall = new Challenge(name, mode, maxPlayer, seg, desc, url);
		try {
			return dao.create(chall);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void update(long id, String name, int maxPlayer, Mode mode) {
		Challenge chall = getById(id);
		if (name != null)
			chall.setName(name);
		if (maxPlayer != 0)
			chall.setMaxPlayer(maxPlayer);
		if (mode != null)
			chall.setMode(mode);
		try {
			dao.edit(chall);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

	public Challenge modifyImage(long id, String url) {
		Challenge chall = getById(id);
		chall.setUrl(url);
		try {
			dao.edit(chall);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chall;
	}

	public Challenge modifyDescription(long id, String desc) {
		Challenge chall = getById(id);
		chall.setDescription(desc);
		try {
			dao.edit(chall);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chall;		
	}

	public void removeCheckpoint(long id, long idcheckpoint) {
		Challenge chall = getById(id);
		
		// get checkpoint 
		
		List<Segment>segs = chall.getSegments();
		for(int i = 0 ; i < segs.size(); i++) {
			if(segs.get(i).getDest().getId() == idcheckpoint);
		}
		
		// case 1 the checkpoint is the first checkpoint
		
		// case 2 the checkpoint is the last checkpoint
		
		// case 3 the checkpoint is in the middle 
		
	}

	public Challenge addSegment(long id, long idSeg) {
		Segment seg = segDao.find(idSeg);
		Challenge chall = dao.find(id);
		chall.getSegments().add(seg);
		try {
			dao.edit(chall);
		} catch (SecurityException | IllegalStateException | NotSupportedException | SystemException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chall;
		
		
	}

}
