package model;

import javax.persistence.Column;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private long idSource;
	@Column
	private long idDest;
	@Column
	private long idObstacle;
	
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

	@Override
	public String toString() {
		return "Segment [id=" + id + ", idSource=" + idSource + ", idDest=" + idDest + ", idObstacle=" + idObstacle
				+ "]";
	}

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
