package cn.edu.qut.service.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.app.SupplierOrderDao2;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.app.SupplierOrder;

@Service
public class SupplierOrderService2 {

	@Autowired
	private SupplierOrderDao2 supplierOrderDao;
	
	public List<SupplierOrder> findAll(SupplierOrder s){
		return supplierOrderDao.findAll(s);
	}
	
	public boolean addSupplierOrder(SupplierOrder s){
		s.setOrder_state("1");
		return supplierOrderDao.addSupplierOrder(s);
	}
	public List<SupplierOrder> findAllSuOrder(SupplierOrder s){
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
		return supplierOrderDao.selectOrder(o);
	}
}	
