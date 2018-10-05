package cn.edu.qut.service;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.BaseService;
import cn.edu.qut.dao.GradeDao;
import cn.edu.qut.entity.Grade;
import cn.edu.qut.entity.Seller;
@Service
public class GradeService implements BaseService<Grade>{
	@Autowired
	GradeDao gradeDao;
	
	public boolean add(Grade t) {
		// TODO Auto-generated method stub
		//获取用用户id
		//设置订单人的id
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		return gradeDao.add(t);
	}

	public boolean delete(Grade t) {
		// TODO Auto-generated method stub
		return gradeDao.delete(t);
	}

	public boolean update(Grade t) {
		// TODO Auto-generated method stub
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		return gradeDao.update(t);
	}

	public Grade query(Grade t) {
		// TODO Auto-generated method stub
		return gradeDao.query(t);
	}

	public List<Grade> list(Grade t) {
		// TODO Auto-generated method stub
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		return gradeDao.list(t);
	}
	
	public boolean saveOrUpdate(Grade grade){
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		grade.setStore_id(seller.getStore_id());
		return gradeDao.saveOrUpdate(grade);
	}
	
	public List<Map<String,Object>> queryCustomerByName(String customer_login_name){
		return gradeDao.queryCustomerByName(customer_login_name);
	}

}
