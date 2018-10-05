package cn.edu.qut.dao;

import java.util.List;
import java.util.Map;

import base.BaseDao;
import cn.edu.qut.entity.Grade;

public interface GradeDao extends BaseDao<Grade>{
	
	boolean saveOrUpdate(Grade grade);
	
	List<Map<String,Object>> queryCustomerByName(String customer_login_name);
	
}
