package cn.edu.qut.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.qut.entity.Address;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.service.SellerOrderService;
import cn.edu.qut.tools.Password;
import cn.edu.qut.tools.Tool;


@RequestMapping("sellerOrder")
@Controller

public class SellerOrderController {
	@Autowired
	SellerOrderService sellerOrderService;
	
	//查询店铺中所有的商品
	@RequiresPermissions("sellerOrder:list")
	@RequestMapping("list")
	String list(Goods goods,Model model){
		 List<Goods> list = sellerOrderService.list(goods);
		 model.addAttribute("list", list);
		 return "sellerOrderList";
	}
	
	//下订单
	@RequiresPermissions("sellerOrder:add")
	@RequestMapping("add")
	String add(Integer goods_id[],Float goods_price[],Integer goods_num[],String attribute[],Address address,Order order){
		
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		String user_name = user.getSeller_login_name();
		List<OrderGoods> list = new ArrayList<OrderGoods>();
		float sum = 0;
		for(int i = 0;i<goods_id.length;i++){
			OrderGoods og = new OrderGoods();
			og.setGoods_id(goods_id[i]);
			og.setGoods_price(goods_price[i]);
			og.setOrder_goods_state("0");
			og.setGoods_num(goods_num[i]);
			og.setCustomer(user_name);
			og.setStore_id(user.getStore_id());
			og.setAttribute(attribute[i]);
			list.add(og);
			
			//计算总额
			sum+=goods_price[i];
		}
		
		//生成系统时间
		order.setOrder_time(Tool.getTimeNow());
		order.setOrder_money(sum);
		order.setOrderGoodsList(list);
		order.setOrder_state("0");
		order.setCustomer(user_name);
		
		//分配订单号
		//20180503AAA 8+24=32
		String s = order.getOrder_time().substring(0,9).replaceAll("-","");
		String order_number=s+Password.getRandomPassWord(24);
		order.setOrder_number(order_number);
		
		order.setAddress("收件人:"+address.getAddress_contact()+",手机号:"+address.getAddress_phone()+",地址:"+address.getAddress_content());
		order.setStore_id(user.getStore_id());
		//order.setOrder_epay_type(order_epay_type);
		
		//System.out.println(order.toString());
		//封装成一个Order,其中包含子表list
		/*==order_id
		order_time
		order_money
		order_state
		customer
		order_number
		address
		store_id
		order_time_send
		order_epay_type
		seller_id*/

		//插入
		boolean flag = sellerOrderService.add(order);
		//System.out.println(flag);
		return "redirect:/order/list";
	}
	
	
}
