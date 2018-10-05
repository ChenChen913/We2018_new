package cn.edu.qut.entity.app;

import java.util.List;

import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.OrderGoods;

public class GoodsAttr {
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
	String sort_name;
	String supplier_name;
	
	 Integer goodsNum;
	//属性子表
	Integer attribute_id;
	String attribute_name;
	Integer attribute_repertory;
	String attribute_memo;
	Float attribute_price0;
	Float attribute_price;
	Float attribute_price_agent;
	Float attribute_price_vip;
	
	public GoodsAttr() {
		
	}
	public GoodsAttr(Goods goods,Attribute attr) {
		this.goods_id = goods.getGoods_id();
		this.sort_id = goods.getSort_id();
		this.goods_name = goods.getGoods_name();
		this.goods_img1 = goods.getGoods_img1();
		this.goods_img2 = goods.getGoods_img2();
		this.goods_img3 = goods.getGoods_img3();
		this.goods_content = goods.getGoods_content();
		this.goods_state = goods.getGoods_state();
		this.goods_start_time = goods.getGoods_start_time();
		this.store_id = goods.getStore_id();
		this.supplier_id = goods.getSupplier_id();
		this.seller_id = goods.getSeller_id();
		this.sort_name = goods.getSort_name();
		this.supplier_name = goods.getSupplier_name();
		
		this.attribute_id = attr.getAttribute_id();
		this.attribute_name = attr.getAttribute_name();
		this.attribute_repertory = attr.getAttribute_repertory();
		this.attribute_memo = attr.getAttribute_memo();
		this.attribute_price0 = attr.getAttribute_price0();
		this.attribute_price = attr.getAttribute_price();
		this.attribute_price_agent = attr.getAttribute_price_agent();
		this.attribute_price_vip = attr.getAttribute_price_vip();
	}



	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
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
	public Integer getAttribute_id() {
		return attribute_id;
	}
	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
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



	
	
}
