package cn.edu.qut.dao;

import java.util.List;
import java.util.Map;

import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Clerk_permission;


public interface ClerkDao {
	List<Map<String,Object>>queryClerkBySellerName(String seller_login_name);
	
	//返回插入条数，但是可以自己将seller_id赋值主键值
	
	int addClerk(Seller seller);
	/*int addClerkRole(Seller_role seller_role);*/
	
	Map<String,Object> queryClerkById(String seller_id);
	
	
	//物理删除
	/*boolean deleteClerkRole_physics(String seller_id);*/
	boolean deleteClerkById_physics(String seller_id);
	
	//校验用户名
	int validate(String seller_login_name);
	
	//给员工批量添加权限
	//1.员工id或者是seller_login_name
	//2.权限码的id permission_id
	boolean authorizeClerkByBatch(List<Clerk_permission> list);
	
	//根据店员id去查找店员的所有权限
	List<Map<String,Object>> queryClerkPermission(String clerk_id);
	
	//根据店主的id去查找店主的所有权限
	List<Map<String,Object>> querySellerPermission(String seller_id);
	
	//根据用户id查找用户名
	String selectNameByclerkID(String clerk_id);
	
	//根据id查找该店员所有的自定义权限
	boolean deleteAllClerkPermissionById(String clerk_id);
	
}
