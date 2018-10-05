package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.qut.dao.SupplierOrderDao;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.SupplierOrder;

@Service
public class SupplierOrderService {

	@Autowired
	private SupplierOrderDao supplierOrderDao;
	
	public List<SupplierOrder> findAll(SupplierOrder s){
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		s.setStore_id(seller.getStore_id().toString());
		return supplierOrderDao.findAll(s);
	}
	
	public boolean addSupplierOrder(SupplierOrder s){
		s.setOrder_state("1");
		return supplierOrderDao.addSupplierOrder(s);
	}
	public List<SupplierOrder> findAllSuOrder(SupplierOrder s){
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		s.setStore_id(seller.getStore_id().toString());
		return supplierOrderDao.findAllSuOrder(s);
	}
	public boolean updateOrder(SupplierOrder s){
		s.setOrder_state("2");
		return supplierOrderDao.updateOrder(s);
	}
	
	public boolean updateOrderState(Order o){
		return supplierOrderDao.updateOrderState(o);
	}
	public boolean updateOrderGoods(Order o){
		return supplierOrderDao.updateOrderGoods(o);
	}
	public List<Order> selectOrder(Order o){
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		o.setStore_id(seller.getStore_id());

		return supplierOrderDao.selectOrder(o);
	}
}	
