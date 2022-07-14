package com.security.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Builder;

@Builder
@Entity


public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userName;
	private String userPassword;
	private String userRole;
	private int userEnable;
	

	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, String userPassword, String userRole, int userEnable) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.userEnable = userEnable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public int getUserEnable() {
		return userEnable;
	}
	public void setUserEnable(int userEnable) {
		this.userEnable = userEnable;
	}

	
	
}
