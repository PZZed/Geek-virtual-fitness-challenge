package model;

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
	
	public Challenge() {
		
	}

	public Challenge(Mode mode, int maxPlayer, String name) {
		super();
		this.mode = mode;
		this.maxPlayer = maxPlayer;
		this.name = name;
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

	
}
