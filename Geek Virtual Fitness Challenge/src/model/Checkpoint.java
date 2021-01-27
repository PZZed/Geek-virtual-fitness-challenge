package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Checkpoint {
	//obstacle
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String action;
	
	public Checkpoint() {
		super();
	}

	public Checkpoint(String name, String action) {
		super();
		
		this.name = name;
		this.action = action;
	}
	
	
	
	
}
