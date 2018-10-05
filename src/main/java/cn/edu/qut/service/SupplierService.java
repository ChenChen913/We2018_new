package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.BaseService;
import cn.edu.qut.dao.SupplierDao;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Supplier;
@Service
public class SupplierService implements BaseService<Supplier>{
	@Autowired
	SupplierDao supplierDao;
	
	public boolean add(Supplier t) {
		// TODO Auto-generated method stub
		//获取用用户id
		//设置订单人的id
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		return supplierDao.add(t);
	}

	public boolean delete(Supplier t) {
		// TODO Auto-generated method stub
		return supplierDao.delete(t);
	}

	public boolean update(Supplier t) {
		// TODO Auto-generated method stub
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		return supplierDao.update(t);
	}

	public Supplier query(Supplier t) {
		// TODO Auto-generated method stub
		return supplierDao.query(t);
	}

	public List<Supplier> list(Supplier t) {
		// TODO Auto-generated method stub
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		return supplierDao.list(t);
	}

}
