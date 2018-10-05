package cn.edu.qut.entity;

import java.io.Serializable;

public class Store implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer store_id;
	String store_name;
	String store_img;
	String store_content;
	Integer seller_id;
	String store_state;
	String store_start_time;
	String store_end_time;
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getStore_img() {
		return store_img;
	}
	public void setStore_img(String store_img) {
		this.store_img = store_img;
	}
	public String getStore_content() {
		return store_content;
	}
	public void setStore_content(String store_content) {
		this.store_content = store_content;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	public String getStore_state() {
		return store_state;
	}
	public void setStore_state(String store_state) {
		this.store_state = store_state;
	}
	public String getStore_start_time() {
		return store_start_time;
	}
	public void setStore_start_time(String store_start_time) {
		this.store_start_time = store_start_time;
	}
	public String getStore_end_time() {
		return store_end_time;
	}
	public void setStore_end_time(String store_end_time) {
		this.store_end_time = store_end_time;
	}
	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", store_name=" + store_name + ", store_img=" + store_img
				+ ", store_content=" + store_content + ", seller_id=" + seller_id + ", store_state=" + store_state
				+ ", store_start_time=" + store_start_time + ", store_end_time=" + store_end_time + "]";
	}
	
	
}
