package model;

import java.util.List;

//github.com/PZZed/Geek-virtual-fitness-challenge.git
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

	private Step source;
	private Step dest;
	private List<Checkpoint> obstacles;
	
	
	public Segment() {}
	
	public Segment(Step source, Step dest, List<Checkpoint> obstacles) {
		this.source = source;
		this.dest = dest;
		this.obstacles = obstacles;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Step getSource() {
		return source;
	}
	public void setSource(Step source) {
		this.source = source;
	}
	public Step getDest() {
		return dest;
	}
	public void setDest(Step dest) {
		this.dest = dest;
	}
	public List<Checkpoint> getObstacles() {
		return obstacles;
	}
	public void setObstacles(List<Checkpoint> obstacles) {
		this.obstacles = obstacles;
	}





}
