package cn.edu.qut.controller.app;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.qut.entity.Address;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.app.GoodsAttr;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.GoodsService;
import cn.edu.qut.service.OrderService;
import cn.edu.qut.service.app.OrderAndroidService;


@Controller
@RequestMapping("/app")
public class OrderAndroidController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderAndroidService orderAndroidService;
	@Autowired
	GoodsService goodsSercice;
	
	//查询购物车中所有的商品，订单子表list
	@RequestMapping("/shoppartClient")
	@ResponseBody
	public List<OrderGoods> shoppingCartClient(String user_name){
		//获取user_id
		List<OrderGoods> orderGoodsList = orderService.shoppingCart(user_name);
		for(OrderGoods og : orderGoodsList){
			Goods goodsin = new Goods();
			goodsin.setGoods_id(og.getGoods_id());
			Goods goods = goodsSercice.query(goodsin);
			og.setCustomer(goods.getGoods_name());
		}
		System.out.println("购物车："+orderGoodsList.toString());
		return orderGoodsList;
	}
	
	
	
	//模拟网购物车添加商品的情景
	@RequestMapping("/addordergoodsclient")
	@ResponseBody
	public Result addOrderGoodsClient(OrderGoods orderGoods){
		boolean flag = orderAndroidService.addOrderGoods(orderGoods);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("添加成功");
		}else{
			result.setSuccess("true");
			result.setMessage("添加失败");
		}
		return result;
	}
	
	//删除购物车商品
	@RequestMapping("/delshoppartClient")
	@ResponseBody
	public Result deleteShopCartClient(OrderGoods ogoods){
		boolean flag = orderAndroidService.deleteShopCart(ogoods);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("删除成功");
		}else{
			result.setSuccess("true");
			result.setMessage("删除失败");
		}
		return result;
	}
	
	//生成订单

	@RequestMapping("/addorderClient")
	@ResponseBody
	public Result add(Order order,Address address,String order_goods_idStr){
		String[] order_goods_id = order_goods_idStr.split(",");
		System.out.println("store_id"+order.getStore_id());
		order.setAddress("收件人:"+address.getAddress_contact()+",手机号:"+address.getAddress_phone()+",地址:"+address.getAddress_content());
		boolean flag = orderAndroidService.add(order,order_goods_id);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("下单成功");
		}else{
			result.setSuccess("true");
			result.setMessage("下单失败");
		}
		return result;
	}
	
	@RequestMapping("/orderlistAndroid")
	@ResponseBody
	public  List<Order> list(String state,String store_id){
		List<Order> orderList = orderAndroidService.list(store_id,state);
		if(state.equals("1")){
			List<Order> orderList1 = orderAndroidService.list(store_id,"2");
			if(!orderList1.isEmpty()){
				orderList.addAll(orderList1);
			}	
		}
		return orderList;
	}
	
	//发货
	@RequestMapping("/sendgoodsAndroid")
	@ResponseBody
	public  Result sendGoods(Order order){
		
		boolean flag = orderAndroidService.sendGoods(order);
		
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("成功");
		}else{
			result.setSuccess("true");
			result.setMessage("失败");
		}
		return result;
	}
	
	@RequestMapping("/orderlistclient")
	@ResponseBody
	public  List<Order> listClient(String state,String store_id){
		List<Order> orderList = orderAndroidService.listClient(store_id,state);
		return orderList;
	}
	//修改订单状态
	@RequestMapping("orderupdateAndroid")
	@ResponseBody
	public Result update(String order_id){
		System.out.println("order_id"+order_id);
		Order order = new Order();
		order.setOrder_id(Integer.parseInt(order_id));
		boolean flag = orderService.update(order);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("成功");
		}else{
			result.setSuccess("true");
			result.setMessage("失败");
		}
		return result;
	}
	
	@RequestMapping("/createorderandroid")
	@ResponseBody
	public  Result createOrder(Order order,Address address,String paytype,String clerklever,String goodslist){
		System.out.println("goodslist : " + goodslist);
		List<GoodsAttr> goodsAttrs = (List<GoodsAttr>) JSON.parseArray(goodslist,GoodsAttr.class);
		boolean flag = true;
		OrderGoods od = null;
		String[] order_goods_id = new String[goodsAttrs.size()];
		int i = 0;
		float money = 0;
		for(GoodsAttr g : goodsAttrs){
			od = new OrderGoods();
			od.setCustomer(order.getCustomer());
			od.setGoods_id(g.getGoods_id());
			od.setGoods_num(g.getGoodsNum());
			od.setStore_id(order.getStore_id());
			od.setAttribute(g.getAttribute_name());	
			System.out.println("clerklever :"+clerklever);
			if(clerklever.equals("2")){
				od.setGoods_price(g.getAttribute_price_agent());
			}
			else if(clerklever.equals("3")){
				od.setGoods_price(g.getAttribute_price_vip());
			}else{
				od.setGoods_price(g.getAttribute_price());
			}
			orderAndroidService.addOrderGoodsP(od);
			System.out.println("id:"+od.getOrder_goods_id());
			order_goods_id[i++] = od.getOrder_goods_id().toString();
			money = money + od.getGoods_price() * od.getGoods_num();
		}
		order.setAddress("收件人:"+address.getAddress_contact()+",手机号:"+address.getAddress_phone()+",地址:"+address.getAddress_content());
		order.setOrder_epay_type(paytype);
		order.setOrder_money(money);
		orderAndroidService.add(order,order_goods_id);
		
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("成功");
		}else{
			result.setSuccess("true");
			result.setMessage("失败");
		}
		return result;
	}
	
	
	
}
