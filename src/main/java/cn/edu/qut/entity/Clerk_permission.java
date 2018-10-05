package cn.edu.qut.entity;

import java.io.Serializable;

public class Clerk_permission implements Serializable{

	/**
	 * 用来给员工授权的实体独对象
	 */
	private static long serialVersionUID = 1L;
	
	String clerk_permission_id;
	String clerk_id;
	String permission_id;
	
	public String getClerk_permission_id() {
		return clerk_permission_id;
	}
	public void setClerk_permission_id(String clerk_permission_id) {
		this.clerk_permission_id = clerk_permission_id;
	}
	public String getClerk_id() {
		return clerk_id;
	}
	public void setClerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
	}
	public String getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
	@Override
	public String toString() {
		return "Clerk_permission [clerk_permission_id=" + clerk_permission_id + ", clerk_id=" + clerk_id
				+ ", permission_id=" + permission_id + "]";
	}
	

	
}
