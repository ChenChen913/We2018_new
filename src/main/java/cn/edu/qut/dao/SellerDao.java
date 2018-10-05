package cn.edu.qut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.qut.entity.Seller;

public interface SellerDao {
	Seller getSellerByUserName(String seller_name);
	
	List<String> findRolesByUserName(String seller_login_name);
	List<String> findPermissionsByUserName(String seller_login_name);
	List<String> listClerkPermission(String seller_login_name);
	
	//增 --没有
	//删除--没有
	//修改
	boolean update(Seller seller);
	
	//查
	Seller query(String seller_id);
	
	boolean updateLogo(@Param("seller_id")Integer seller_id,@Param("seller_img")String seller_img);
	
	//校验密码是否正确
	Integer ajax_password(Seller seller);
	
	boolean updateSellerPassword(Seller seller);
	
	
}
