package model;

public class ChallengeSegments {
	private long idSegment;
	private long idChallenge;
	
	public ChallengeSegments(long idSegment, long idChallenge) {
		this.idSegment = idSegment;
		this.idChallenge = idChallenge;
	}
	public long getIdSegment() {
		return idSegment;
	}
	public void setIdSegment(long idSegment) {
		this.idSegment = idSegment;
	}
	public long getIdChallenge() {
		return idChallenge;
	}
	public void setIdChallenge(long idChallenge) {
		this.idChallenge = idChallenge;
	}
}
