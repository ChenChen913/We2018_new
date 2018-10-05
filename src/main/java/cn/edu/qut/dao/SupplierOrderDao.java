package cn.edu.qut.dao;

import java.util.List;

import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.SupplierOrder;

public interface SupplierOrderDao {
	public List<SupplierOrder> findAll(SupplierOrder s);
	public boolean addSupplierOrder(SupplierOrder s);
	public List<SupplierOrder> findAllSuOrder(SupplierOrder s);
	public boolean updateOrder(SupplierOrder s);
	public boolean updateOrderState(Order o);
	public boolean updateOrderGoods(Order o);
	public List<Order> selectOrder(Order o);
}
