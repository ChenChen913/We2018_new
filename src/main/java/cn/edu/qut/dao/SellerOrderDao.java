package cn.edu.qut.dao;

import java.util.List;

import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;

public interface SellerOrderDao {
	
	//查询店铺中所有的商品
	List<Goods> list(Goods goods);
	//查询商品属性 
	List<Attribute> listAttribute(Integer goods_id);
	
	//生成订单
	boolean add(Order order);
	//添加订单子表
	boolean addOrderGoods(List<OrderGoods> orderGoods);
}
