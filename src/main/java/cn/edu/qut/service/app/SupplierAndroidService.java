package cn.edu.qut.service.app;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.BaseService;
import cn.edu.qut.dao.SupplierDao;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Supplier;
@Service
public class SupplierAndroidService implements BaseService<Supplier>{
	@Autowired
	SupplierDao supplierDao;
	
	public boolean add(Supplier t) {
		// TODO Auto-generated method stub
		//获取用用户id
		//设置订单人的id
//		t.setStore_id(store_id);
		return supplierDao.add(t);
	}

	public boolean delete(Supplier t) {
		// TODO Auto-generated method stub
		return supplierDao.delete(t);
	}

	public boolean update(Supplier t) {
		// TODO Auto-generated method stub
//		t.setStore_id(store_id);
		return supplierDao.update(t);
	}

	public Supplier query(Supplier t) {
		// TODO Auto-generated method stub
		return supplierDao.query(t);
	}

	public List<Supplier> list(Supplier t) {
		// TODO Auto-generated method stub
//		t.setStore_id(store_id);
		return supplierDao.list(t);
	}

}
