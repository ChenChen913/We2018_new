package cn.edu.qut.entity;

import java.io.Serializable;
import java.util.List;

public class Sort implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer sort_id;
	String sort_name;
/*	String sort_grade;
	Integer sort_parent;
	String sort_show;*/
	Integer store_id;
	/*List<Sort> list;*/
	//20180511改一级分类
	
	/*public List<Sort> getList() {
		return list;
	}
	public void setList(List<Sort> list) {
		this.list = list;
	}*/
	public Integer getSort_id() {
		return sort_id;
	}
	public void setSort_id(Integer sort_id) {
		this.sort_id = sort_id;
	}
	public String getSort_name() {
		return sort_name;
	}
	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}
	/*public String getSort_grade() {
		return sort_grade;
	}
	public void setSort_grade(String sort_grade) {
		this.sort_grade = sort_grade;
	}
	
	public Integer getSort_parent() {
		return sort_parent;
	}
	public void setSort_parent(Integer sort_parent) {
		this.sort_parent = sort_parent;
	}
	public String getSort_show() {
		return sort_show;
	}
	public void setSort_show(String sort_show) {
		this.sort_show = sort_show;
	}*/
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	@Override
	public String toString() {
		return "Sort [sort_id=" + sort_id + ", sort_name=" + sort_name + ", store_id=" + store_id + "]";
	}
	
	
	
	
	
	
}
