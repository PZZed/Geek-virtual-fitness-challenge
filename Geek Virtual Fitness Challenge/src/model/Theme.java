package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Theme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String desc;
	private int nbVote;
	
	public Theme() {
		
	}
	
	public Theme(String desc, int nbVote) {
		super();
		this.desc = desc;
		this.nbVote = nbVote;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getNbVote() {
		return nbVote;
	}
	public void setNbVote(int nbVote) {
		this.nbVote = nbVote;
	}
}
