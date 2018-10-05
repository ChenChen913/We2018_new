package cn.edu.qut.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;

public interface OrderDao {
	
	//查询所有订单
	//字段2-是否审核
	List<Order> list(Order order);
	
	//根据id查找订单
	Order query(String order_id);
	
	//根据id查找查询所有子订单
	List<OrderGoods> listOrderGoods(String order_id);
	
	//模拟网购物车添加商品的情景
	boolean addOrderGoods(OrderGoods orderGoods);
	
	//查询订单子表
	List<OrderGoods> shoppingCart(String customer);
	
	//查询是否存在
	int queryIsExistence(OrderGoods orderGoods);
	
	//查询有多啊少
	int queryNum(OrderGoods orderGoods);
	
	//添加商品
	boolean updateOrderGoodsNum(OrderGoods orderGoods);
	
	//删除购物车中的商品
	boolean delete(OrderGoods orderGoods);
	
	//添加订单
	boolean add(Order order);
	
	//修改订单状态
	boolean update(Order order);
	
	//修改子表状态
	boolean updateOrderGoods(@Param("order_goods_id")String order_goods_id,@Param("order_id")String order_id);

	//查询未处理订单的数量
	int queryCountof0();
	
	boolean send(Order order);
}
