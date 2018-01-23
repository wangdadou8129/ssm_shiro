package com.ssm.entity;

import java.util.ArrayList;

public class Users {
	private int userId;
	private String userName;
	private String userPassword;
	//½ÇÉ«ÒýÓÃ
	private ArrayList<Roles> roles;
	
	public ArrayList<Roles> getRoles() {
		return roles;
	}
	public void setRoles(ArrayList<Roles> roles) {
		this.roles = roles;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Users() {
		super();
	}
	
	public Users(int userId, String userName, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	
	public Users(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
}
