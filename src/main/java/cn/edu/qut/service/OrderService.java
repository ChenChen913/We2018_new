package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import cn.edu.qut.dao.OrderDao;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.tools.Password;
import cn.edu.qut.tools.Tool;

@Service
public class OrderService {
	@Autowired
	OrderDao orderDao;
	
	public List<Order> list(String customer,String order_state){
		//设置订单人的id
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		
		Order o = new Order();
		//o.setCustomer(user.getSeller_login_name());
		o.setOrder_state(order_state);
		o.setStore_id(user.getStore_id());
		
		//System.out.println(o);
		
		List<Order> list = orderDao.list(o);
		
		//System.out.println(list);
		for(Order order:list){
			List<OrderGoods> orderGoodsList = orderDao.listOrderGoods(order.getOrder_id().toString());
			order.setOrderGoodsList(orderGoodsList);
		}
		return list;
	}
	
	//模拟网购物车添加商品的情景
	@Transactional
	public boolean addOrderGoods(OrderGoods orderGoods,Model model){
		
		int i = orderDao.queryIsExistence(orderGoods);
		orderGoods.setOrder_goods_state("0");
		//System.out.println("i="+i);
		boolean flag = false;
		if(i>0){
			//System.out.println("商品存在");
			int num = orderDao.queryNum(orderGoods);
			int count = orderGoods.getGoods_num()+num;
			//System.out.println("count="+count+",orderGoods.getGoods_num()"+orderGoods.getGoods_num()+",i="+i);
			//已经存在该商品，修改一下商品数量即可
			orderGoods.setGoods_num(count);
			//System.out.println(orderGoods);
			flag = orderDao.updateOrderGoodsNum(orderGoods);
			model.addAttribute("flag", flag);
		}
		else{
			//System.out.println("商品不存在");
			//商品不存在要进行插入操作
			flag = orderDao.addOrderGoods(orderGoods);
		}
		return flag;
	}
	
	//查询订单子表list
	public List<OrderGoods> shoppingCart(String order_goods_user_id){
		return orderDao.shoppingCart(order_goods_user_id);
	}
	
	//删除购物车中的商品
	public boolean delete(OrderGoods orderGoods){
		return orderDao.delete(orderGoods);
	}
	
	//产生订单
	public boolean add(Order order,String[] order_goods_id){
		//生成系统时间
		order.setOrder_time(Tool.getTimeNow());
		
		//计算订单金额
		//已经在前台计算好回传了
		
		//设置订单状态
		order.setOrder_state("0");
		
		//设置订单人的id
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		order.setSeller_id(user.getSeller_id());
		
		//分配订单号
		//20180503AAA 8+24=32
		String s = order.getOrder_time().substring(0,9).replaceAll("-","");
		String order_number=s+Password.getRandomPassWord(24);
		order.setOrder_number(order_number);
		
		//System.out.println(order.toString());
		
		//添加订单
		boolean flag = orderDao.add(order);
		
		Integer order_id = order.getOrder_id();
		//System.out.println("order_id="+order_id);
		
		for(String temp:order_goods_id){
			//修改子表状态
			boolean flag2 = orderDao.updateOrderGoods(temp,order_id.toString());
		}
		
		return true;
		
	}
	
	//修改订单状态
	public boolean update(Order order){
		//设置订单人的id
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		order.setSeller_id(user.getSeller_id());
		return orderDao.update(order);
	}
		
	//查询未处理订单的数量
	public int queryCountof0(){
		return orderDao.queryCountof0();
	}
	
	//根据id查找订单以及子表
	public Order query(String order_id){
		Order order = orderDao.query(order_id);
		List<OrderGoods> orderGoodsList = orderDao.listOrderGoods(order_id);
		order.setOrderGoodsList(orderGoodsList);
		return order;
	}
	
	public boolean send(Order order){
		order.setOrder_time_send(Tool.getTimeNow());
		return orderDao.send(order);
	}
}
