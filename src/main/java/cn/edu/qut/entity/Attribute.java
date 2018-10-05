package cn.edu.qut.entity;

public class Attribute implements Cloneable{
	
	Integer attribute_id;
	Integer goods_id;
	String attribute_name;
	Integer attribute_repertory;
	String attribute_memo;
	Float attribute_price0;
	Float attribute_price;
	Float attribute_price_agent;
	Float attribute_price_vip;
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	public Attribute() {
		super();
	}
	public Attribute(Integer attribute_id, Integer goods_id, String attribute_name, Integer attribute_repertory,
			String attribute_memo, Float attribute_price0, Float attribute_price, Float attribute_price_agent,
			Float attribute_price_vip) {
		super();
		this.attribute_id = attribute_id;
		this.goods_id = goods_id;
		this.attribute_name = attribute_name;
		this.attribute_repertory = attribute_repertory;
		this.attribute_memo = attribute_memo;
		this.attribute_price0 = attribute_price0;
		this.attribute_price = attribute_price;
		this.attribute_price_agent = attribute_price_agent;
		this.attribute_price_vip = attribute_price_vip;
	}
	public Integer getAttribute_id() {
		return attribute_id;
	}
	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public String getAttribute_name() {
		return attribute_name;
	}
	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	public Integer getAttribute_repertory() {
		return attribute_repertory;
	}
	public void setAttribute_repertory(Integer attribute_repertory) {
		this.attribute_repertory = attribute_repertory;
	}
	public String getAttribute_memo() {
		return attribute_memo;
	}
	public void setAttribute_memo(String attribute_memo) {
		this.attribute_memo = attribute_memo;
	}
	public Float getAttribute_price0() {
		return attribute_price0;
	}
	public void setAttribute_price0(Float attribute_price0) {
		this.attribute_price0 = attribute_price0;
	}
	public Float getAttribute_price() {
		return attribute_price;
	}
	public void setAttribute_price(Float attribute_price) {
		this.attribute_price = attribute_price;
	}
	public Float getAttribute_price_agent() {
		return attribute_price_agent;
	}
	public void setAttribute_price_agent(Float attribute_price_agent) {
		this.attribute_price_agent = attribute_price_agent;
	}
	public Float getAttribute_price_vip() {
		return attribute_price_vip;
	}
	public void setAttribute_price_vip(Float attribute_price_vip) {
		this.attribute_price_vip = attribute_price_vip;
	}
	@Override
	public String toString() {
		return "Attribute [attribute_id=" + attribute_id + ", goods_id=" + goods_id + ", attribute_name="
				+ attribute_name + ", attribute_repertory=" + attribute_repertory + ", attribute_memo=" + attribute_memo
				+ ", attribute_price0=" + attribute_price0 + ", attribute_price=" + attribute_price
				+ ", attribute_price_agent=" + attribute_price_agent + ", attribute_price_vip=" + attribute_price_vip
				+ "]";
	}
	
	
	
	
	
}
