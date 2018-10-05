package cn.edu.qut.entity;

public class Supplier {
	
	Integer supplier_id;
	String supplier_name;
	String supplier_contacts;
	String supplier_phone;
	String supplier_epay;
	Integer store_id;
	public Integer getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Integer supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	public String getSupplier_contacts() {
		return supplier_contacts;
	}
	public void setSupplier_contacts(String supplier_contacts) {
		this.supplier_contacts = supplier_contacts;
	}
	public String getSupplier_phone() {
		return supplier_phone;
	}
	public void setSupplier_phone(String supplier_phone) {
		this.supplier_phone = supplier_phone;
	}
	public String getSupplier_epay() {
		return supplier_epay;
	}
	public void setSupplier_epay(String supplier_epay) {
		this.supplier_epay = supplier_epay;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	@Override
	public String toString() {
		return "Supplier [supplier_id=" + supplier_id + ", supplier_name=" + supplier_name + ", supplier_contacts="
				+ supplier_contacts + ", supplier_phone=" + supplier_phone + ", supplier_epay=" + supplier_epay
				+ ", store_id=" + store_id + "]";
	}
	
	
}
