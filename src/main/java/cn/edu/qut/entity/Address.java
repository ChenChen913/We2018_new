package cn.edu.qut.entity;

import java.io.Serializable;

public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer address_id;
	String address_content;
	String address_contact;
	String address_type;
	String address_phone;
	Integer customer_id;
	String address_memo;
	public Integer getAddress_id() {
		return address_id;
	}
	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}
	public String getAddress_content() {
		return address_content;
	}
	public void setAddress_content(String address_content) {
		this.address_content = address_content;
	}
	public String getAddress_contact() {
		return address_contact;
	}
	public void setAddress_contact(String address_contact) {
		this.address_contact = address_contact;
	}
	public String getAddress_type() {
		return address_type;
	}
	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}
	public String getAddress_phone() {
		return address_phone;
	}
	public void setAddress_phone(String address_phone) {
		this.address_phone = address_phone;
	}
	public Integer getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}
	public String getAddress_memo() {
		return address_memo;
	}
	public void setAddress_memo(String address_memo) {
		this.address_memo = address_memo;
	}
	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address_content=" + address_content + ", address_contact="
				+ address_contact + ", address_type=" + address_type + ", address_phone=" + address_phone
				+ ", customer_id=" + customer_id + ", address_memo=" + address_memo + "]";
	}
	
}
