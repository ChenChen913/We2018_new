package cn.edu.qut.entity;

import java.io.Serializable;

public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer customer_id;
	Integer role_id;
	String customer_login_name;
	String customer_real_name;
	String customer_password;
	String customer_img;
	String customer_reg_date;
	String customer_phone;
	String customer_epay;
	String customer_state;
	Integer seller_id;
	String customer_email;
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public String getCustomer_login_name() {
		return customer_login_name;
	}
	public void setCustomer_login_name(String customer_login_name) {
		this.customer_login_name = customer_login_name;
	}
	public String getCustomer_real_name() {
		return customer_real_name;
	}
	public void setCustomer_real_name(String customer_real_name) {
		this.customer_real_name = customer_real_name;
	}
	public String getCustomer_password() {
		return customer_password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}
	public String getCustomer_img() {
		return customer_img;
	}
	public void setCustomer_img(String customer_img) {
		this.customer_img = customer_img;
	}
	public String getCustomer_reg_date() {
		return customer_reg_date;
	}
	public void setCustomer_reg_date(String customer_reg_date) {
		this.customer_reg_date = customer_reg_date;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_epay() {
		return customer_epay;
	}
	public void setCustomer_epay(String customer_epay) {
		this.customer_epay = customer_epay;
	}
	public String getCustomer_state() {
		return customer_state;
	}
	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", role_id=" + role_id + ", customer_login_name="
				+ customer_login_name + ", customer_real_name=" + customer_real_name + ", customer_password="
				+ customer_password + ", customer_img=" + customer_img + ", customer_reg_date=" + customer_reg_date
				+ ", customer_phone=" + customer_phone + ", customer_epay=" + customer_epay + ", customer_state="
				+ customer_state + ", seller_id=" + seller_id + "]";
	}
	
	
}
