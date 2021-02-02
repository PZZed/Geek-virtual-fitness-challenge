package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Challenge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Mode mode;
	private int maxPlayer;
	private String name;
	private List<Segment> segments;
	private String description;
	private String url; 
	public Challenge() {

	}

	public List<Segment> getSegments() {
		return segments;
	}

	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public int getMaxPlayer() {
		return maxPlayer;
	}

	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Challenge(String name, Mode mode, int maxPlayer, List<Segment> segments, String description,String url) {
		super();
		this.mode = mode;
		this.maxPlayer = maxPlayer;
		this.name = name;
		this.segments = segments;
		this.description = description;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
