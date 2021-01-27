package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Segment {
	//segment
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Step source , dest;
	private Checkpoint obstacle;
	
	public Segment() {
		super();
	}
	
	public Segment(Step source, Step dest, Checkpoint obstacle) {
		super();
		this.source = source;
		this.dest = dest;
		this.obstacle = obstacle;
	}
	
	
}
