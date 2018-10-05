package cn.edu.qut.entity;

import java.io.Serializable;

public class Grade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer grade_id;
	Integer store_id;
	Integer customer_id;
	String grade_type;
	
	//补充字段
	String customer_login_name;
	//count 查询的数量
	Integer count;
	
	
	
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCustomer_login_name() {
		return customer_login_name;
	}
	public void setCustomer_login_name(String customer_login_name) {
		this.customer_login_name = customer_login_name;
	}
	public Integer getGrade_id() {
		return grade_id;
	}
	public void setGrade_id(Integer grade_id) {
		this.grade_id = grade_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getGrade_type() {
		return grade_type;
	}
	public void setGrade_type(String grade_type) {
		this.grade_type = grade_type;
	}
	@Override
	public String toString() {
		return "Grade [grade_id=" + grade_id + ", store_id=" + store_id + ", customer_id=" + customer_id
				+ ", grade_type=" + grade_type + "]";
	}
	
}
