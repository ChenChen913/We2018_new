package cn.edu.qut.entity;

public class SupplierOrder {
	Integer supplier_order_id;
	Integer goods_id;
	Integer attribute_id;
	String order_number;
	String goods_name;
	String attribute_name;
	Integer goods_num;
	String order_state;
	String store_id;
	public Integer getSupplier_order_id() {
		return supplier_order_id;
	}
	public void setSupplier_order_id(Integer supplier_order_id) {
		this.supplier_order_id = supplier_order_id;
	}
	public Integer getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getAttribute_id() {
		return attribute_id;
	}
	public void setAttribute_id(Integer attribute_id) {
		this.attribute_id = attribute_id;
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
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
	public Integer getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub 
		return "SupplierOrder:"+" supplier_order_id:"+supplier_order_id+"  goods_name:" +goods_name +"  attribute_name:"+attribute_name+"  goods_num:"+goods_num+"  order_state"+order_state;
	}
}
