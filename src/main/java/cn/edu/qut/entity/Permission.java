package cn.edu.qut.entity;

import java.io.Serializable;

public class Permission implements Serializable{
	
	Integer permission_id;
	String permission_order;
	String permission_name;
	String permission_code;
	String permission_isNavi;
	String permission_url;
	String permission_state;
	public Integer getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Integer permission_id) {
		this.permission_id = permission_id;
	}
	public String getPermission_order() {
		return permission_order;
	}
	public void setPermission_order(String permission_order) {
		this.permission_order = permission_order;
	}
	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getPermission_code() {
		return permission_code;
	}
	public void setPermission_code(String permission_code) {
		this.permission_code = permission_code;
	}
	public String getPermission_isNavi() {
		return permission_isNavi;
	}
	public void setPermission_isNavi(String permission_isNavi) {
		this.permission_isNavi = permission_isNavi;
	}
	public String getPermission_url() {
		return permission_url;
	}
	public void setPermission_url(String permission_url) {
		this.permission_url = permission_url;
	}
	public String getPermission_state() {
		return permission_state;
	}
	public void setPermission_state(String permission_state) {
		this.permission_state = permission_state;
	}
	@Override
	public String toString() {
		return "Permission [permission_id=" + permission_id + ", permission_order=" + permission_order
				+ ", permission_name=" + permission_name + ", permission_code=" + permission_code
				+ ", permission_isNavi=" + permission_isNavi + ", permission_url=" + permission_url
				+ ", permission_state=" + permission_state + "]";
	}
	
	
	
	
}
