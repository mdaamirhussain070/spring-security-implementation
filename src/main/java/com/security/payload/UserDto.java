package com.security.payload;

import lombok.Builder;


public class UserDto {
	
	
	
	private int id;
	private String userName;
	private String userPassword;
	private String userRole;
	private String userEnable;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String userName, String userPassword, String userRole, String userEnable) {
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
	public String getUserEnable() {
		return userEnable;
	}
	public void setUserEnable(String userEnable) {
		this.userEnable = userEnable;
	}
	
	
}
