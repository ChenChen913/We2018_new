package cn.edu.qut.dao;

import java.util.List;
import java.util.Map;

import cn.edu.qut.entity.Permission;

public interface PermissionDao {
	
	List<Permission> findNavisByRoleId(Integer role_id);
	
	//根据用户id查找菜单
	List<Map<String,?>> queryMenu(String seller_login_name);
		
	//查询所有一级菜单
	List<Map<String,Object>> queryMenu1();
	
	//查询店员额外的2级菜单
	List<Map<String,?>> clerkMenuList(String seller_login_name);
	
	
}
