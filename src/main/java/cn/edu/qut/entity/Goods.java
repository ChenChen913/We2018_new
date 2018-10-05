package cn.edu.qut.entity;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable{
	/**
	 * 
	 */
	private static long serialVersionUID = 1L;
	Integer goods_id;
	Integer sort_id;
	String goods_name;
	String goods_img1;
	String goods_img2;
	String goods_img3;
	String goods_content;
	String goods_state;
	String goods_start_time;
	Integer store_id;
	Integer supplier_id;
	Integer seller_id;
	
	//补充字段
	String sort_name;
	String supplier_name;
	
	//属性
	List<Attribute> attributeList;
	int attributeListSize;
	
	
	
	public int getAttributeListSize() {
		return attributeListSize;
	}
	public void setAttributeListSize(int attributeListSize) {
		this.attributeListSize = attributeListSize;
	}
	public List<Attribute> getAttributeList() {
		return attributeList;
	}
	public void setAttributeList(List<Attribute> attributeList) {
		this.attributeList = attributeList;
		//System.out.println("size()="+attributeList.size());
		this.attributeListSize = attributeList.size();
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getSort_id() {
		return sort_id;
	}
	public void setSort_id(Integer sort_id) {
		this.sort_id = sort_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public String getGoods_img1() {
		return goods_img1;
	}
	public void setGoods_img1(String goods_img1) {
		this.goods_img1 = goods_img1;
	}
	public String getGoods_img2() {
		return goods_img2;
	}
	public void setGoods_img2(String goods_img2) {
		this.goods_img2 = goods_img2;
	}
	public String getGoods_img3() {
		return goods_img3;
	}
	public void setGoods_img3(String goods_img3) {
		this.goods_img3 = goods_img3;
	}
	public String getGoods_content() {
		return goods_content;
	}
	public void setGoods_content(String goods_content) {
		this.goods_content = goods_content;
	}
	public String getGoods_state() {
		return goods_state;
	}
	public void setGoods_state(String goods_state) {
		this.goods_state = goods_state;
	}
	public String getGoods_start_time() {
		return goods_start_time;
	}
	public void setGoods_start_time(String goods_start_time) {
		this.goods_start_time = goods_start_time;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public Integer getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}
	@Override
	public String toString() {
		return "Goods [goods_id=" + goods_id + ", sort_id=" + sort_id + ", goods_name=" + goods_name + ", goods_img1="
				+ goods_img1 + ", goods_img2=" + goods_img2 + ", goods_img3=" + goods_img3 + ", goods_content="
				+ goods_content + ", goods_state=" + goods_state + ", goods_start_time=" + goods_start_time
				+ ", store_id=" + store_id + ", supplier_id=" + supplier_id + ", seller_id=" + seller_id
				+ ", sort_name=" + sort_name + ", supplier_name=" + supplier_name + ", attributeList=" + attributeList
				+ "]";
	}
	
	
}
