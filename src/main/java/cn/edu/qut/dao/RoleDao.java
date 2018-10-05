package cn.edu.qut.dao;

import java.util.List;

import cn.edu.qut.entity.Role;



public interface RoleDao {
	
	List<Role> findRolesBySellerName(String seller_name);
	
}
