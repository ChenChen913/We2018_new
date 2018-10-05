package cn.edu.qut.entity;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{
	/**
	 * 20180502
	 */
	private static final long serialVersionUID = 1L;
	Integer order_id;
	String order_time;
	Float order_money;
	String order_state;
	String customer;
	//订单号
	String order_number;
	String address;
	Integer store_id;
	String order_time_send;
	String order_epay_type;
	Integer seller_id;
	//订单人
	String user_login_name;
	
	//订单子表
	List<OrderGoods> orderGoodsList;
	
	//微信
	String wx;
	

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_time() {
		return order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public Float getOrder_money() {
		return order_money;
	}

	public void setOrder_money(Float order_money) {
		this.order_money = order_money;
	}

	public String getOrder_state() {
		return order_state;
	}

	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}

	

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStore_id() {
		return store_id;
	}

	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}

	public String getOrder_time_send() {
		return order_time_send;
	}

	public void setOrder_time_send(String order_time_send) {
		this.order_time_send = order_time_send;
	}

	public String getOrder_epay_type() {
		return order_epay_type;
	}

	public void setOrder_epay_type(String order_epay_type) {
		this.order_epay_type = order_epay_type;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public String getUser_login_name() {
		return user_login_name;
	}

	public void setUser_login_name(String user_login_name) {
		this.user_login_name = user_login_name;
	}

	public List<OrderGoods> getOrderGoodsList() {
		return orderGoodsList;
	}

	public void setOrderGoodsList(List<OrderGoods> orderGoodsList) {
		this.orderGoodsList = orderGoodsList;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", order_time=" + order_time + ", order_money=" + order_money
				+ ", order_state=" + order_state + ", customer=" + customer + ", order_number=" + order_number
				+ ", address=" + address + ", store_id=" + store_id + ", order_time_send=" + order_time_send
				+ ", order_epay_type=" + order_epay_type + ", seller_id=" + seller_id + ", user_login_name="
				+ user_login_name + ", orderGoodsList=" + orderGoodsList + ", wx=" + wx + "]";
	}

	
	
	
	
	
	
}
