package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String username;
	
	private String password;

	private String mail;

	private Roles role;
	
	private List<Challenge> registeredChallenge;
	
	public User() {
	}

	public User(String username, String password, String mail, Roles role, List<Challenge> registeredChallenge) {
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.role = role;
		this.registeredChallenge = registeredChallenge;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", mail=" + mail + "]";
	}

	public List<Challenge> getRegisteredChallenge() {
		return registeredChallenge;
	}

	public void setRegisteredChallenge(List<Challenge> registeredChallenge) {
		this.registeredChallenge = registeredChallenge;
	}
}
