package dev.charles.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable {
	@Id
	private String roles;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(String roles) {
		super();
		this.roles = roles;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
}
