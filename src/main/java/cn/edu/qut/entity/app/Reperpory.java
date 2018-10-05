package cn.edu.qut.entity.app;

import java.io.Serializable;

public class Reperpory implements Serializable{
	String goods_name;
	String attribute_name;
	String attribute_repertory;
	
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getAttribute_name() {
		return attribute_name;
	}
	public void setAttribute_name(String attribute_name) {
		this.attribute_name = attribute_name;
	}
	public String getAttribute_repertory() {
		return attribute_repertory;
	}
	public void setAttribute_repertory(String attribute_repertory) {
		this.attribute_repertory = attribute_repertory;
	}
	
	
}
