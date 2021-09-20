package dev.charles.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Users implements Serializable {
	@Id
	private String username;
	private String password;
	private boolean active;
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Roles> roles;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String username, String password, boolean active) {
		super();
		this.username = username;
		this.password = password;
		this.active = active;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
