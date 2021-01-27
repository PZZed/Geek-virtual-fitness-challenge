package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Segment {
	// segment
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private long idSource;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdSource() {
		return idSource;
	}

	public void setIdSource(long idSource) {
		this.idSource = idSource;
	}

	public long getIdDest() {
		return idDest;
	}

	public void setIdDest(long idDest) {
		this.idDest = idDest;
	}

	public long getIdObstacle() {
		return idObstacle;
	}

	public void setIdObstacle(long idObstacle) {
		this.idObstacle = idObstacle;
	}

	private long idDest;
	private long idObstacle;

	public Segment() {
		super();
	}

	public Segment(long source, long dest, long obstacle) {
		super();
		this.idSource = source;
		this.idDest = dest;
		this.idObstacle = obstacle;
	}

}
