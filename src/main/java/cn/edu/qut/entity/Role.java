package cn.edu.qut.entity;

import java.io.Serializable;

public class Role implements Serializable{
	Integer role_id;
	String role_name;
	String role_code;
	String role_state;
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public String getRole_state() {
		return role_state;
	}
	public void setRole_state(String role_state) {
		this.role_state = role_state;
	}
	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", role_name=" + role_name + ", role_code=" + role_code + ", role_state="
				+ role_state + "]";
	}
	
	
	
}
