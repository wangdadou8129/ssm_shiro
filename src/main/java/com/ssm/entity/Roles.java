package com.ssm.entity;

import java.util.ArrayList;

public class Roles {
	private int roleId;
	private String roleName;
	//权限引用
	private ArrayList<Permissions> permissions;

	public ArrayList<Permissions> getPermissions() {
		return permissions;
	}
	public void setPermissions(ArrayList<Permissions> permissions) {
		this.permissions = permissions;
	}
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Roles() {
		super();
	}
	
	public Roles(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	
	public Roles(String roleName) {
		super();
		this.roleName = roleName;
	}
}
