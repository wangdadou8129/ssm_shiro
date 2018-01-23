package com.ssm.entity;

public class Permissions {
	private int permissionId;
	private String permissionName;
	
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public Permissions(int permissionId, String permissionName) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
	}
	public Permissions() {
		super();
	}
	public Permissions(String permissionName) {
		super();
		this.permissionName = permissionName;
	}
}
