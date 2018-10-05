package cn.edu.qut.entity.app;

import java.io.Serializable;

public class Grade implements Serializable{
	String grade_id;
	String store_id;
	String customer_id;
	String grade_type;
	
	
	public String getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getGrade_type() {
		return grade_type;
	}
	public void setGrade_type(String grade_type) {
		this.grade_type = grade_type;
	}
}
