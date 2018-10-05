package cn.edu.qut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.qut.entity.Store;

public interface StoreDao {
	//增
	boolean add(Store store);
	//删
	boolean delete(String store_id);
	//改
	boolean update(Store store);
	//查
	Store  query(Integer seller_id);
	List<Store> list();
	
	boolean updateLogo(@Param("store_id")Integer store_id,@Param("store_img")String store_img);
}
