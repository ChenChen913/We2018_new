package cn.edu.qut.dao.app;

import java.util.List;

import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;

public interface OrderAndroidDao {
	//删除购物车中的商品
	boolean delete(OrderGoods orderGoods);
	
	List<Order> list(Order order);
	boolean sendGoods(Order order);
}
