package cn.edu.qut.entity;

import java.io.Serializable;

public class OrderGoods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer order_goods_id;
	Integer order_id;
	Integer goods_id;
	Integer goods_num;
	//记录买的时候的价格
	Float goods_price;
	String order_goods_state;
	
	String customer;
	Integer store_id;
	String attribute;
	
	
	//添加字段
	String goods_name;
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public Integer getOrder_goods_id() {
		return order_goods_id;
	}
	public void setOrder_goods_id(Integer order_goods_id) {
		this.order_goods_id = order_goods_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}
	public Float getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Float goods_price) {
		this.goods_price = goods_price;
	}
	public String getOrder_goods_state() {
		return order_goods_state;
	}
	public void setOrder_goods_state(String order_goods_state) {
		this.order_goods_state = order_goods_state;
	}
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	@Override
	public String toString() {
		return "OrderGoods [order_goods_id=" + order_goods_id + ", order_id=" + order_id + ", goods_id=" + goods_id
				+ ", goods_num=" + goods_num + ", goods_price=" + goods_price + ", order_goods_state="
				+ order_goods_state + ", customer=" + customer + ", store_id=" + store_id + ", attribute=" + attribute
				+ "]";
	}

	
	
	
	
	
}
