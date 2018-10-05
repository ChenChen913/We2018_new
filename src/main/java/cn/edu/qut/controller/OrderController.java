package cn.edu.qut.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.edu.qut.entity.Address;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.service.OrderService;


@RequestMapping("order")
@Controller

public class OrderController {
	@Autowired
	OrderService orderService;
	

	@RequiresPermissions("order:list")
	@RequestMapping("list")
	String list(Model model,@RequestParam(required=true,defaultValue="1") Integer page,  
	         @RequestParam(required=false,defaultValue="5") Integer pageSize,
	         @RequestParam(required=true,defaultValue="1") Integer page2,  
	         @RequestParam(required=false,defaultValue="5") Integer pageSize2){
		
		//查询未审核的
		PageHelper.startPage(page, pageSize);
		
		List<Order> orderList = orderService.list(null,"0");
		
		PageInfo<Order> p = new PageInfo<Order>(orderList);
		model.addAttribute("page", p);
		
		
		//查询已经审核的
		//查询未审核的
		PageHelper.startPage(page2, pageSize2);
		
		List<Order> orderList2 = orderService.list(null,"1");
		
		PageInfo<Order> p2 = new PageInfo<Order>(orderList2);
		model.addAttribute("page2", p2);
		
		//model.addAttribute("orderList", orderList);
		
		return "orderList";
	}
	
	//模拟网购物车添加商品的情景
	@RequiresPermissions("order:addOrderGoods")
	@RequestMapping("addOrderGoods")
	String addOrderGoods(OrderGoods orderGoods,Model model){
		
		//System.out.println("订单子表"+orderGoods.toString());
		//添加用户id
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		String user_name = user.getSeller_login_name();
		orderGoods.setCustomer(user_name);
		
		//System.out.println("add store_id="+orderGoods.getStore_id());
		model.addAttribute("store_id", orderGoods.getStore_id());
		
		boolean flag = orderService.addOrderGoods(orderGoods,model);
		model.addAttribute("flag", flag);
		return "redirect:shoppingCart";
	}
	
	//查询购物车中所有的商品，订单子表list
	@RequestMapping("shoppingCart")
	@RequiresPermissions("order:shoppingCart")
	String shoppingCart(String store_id,Model model){
		model.addAttribute("store_id", store_id);
		//获取user_id
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		String user_name = user.getSeller_login_name();
		List<OrderGoods> orderGoodsList = orderService.shoppingCart(user_name);
		
		model.addAttribute("orderGoodsList", orderGoodsList);
		
	
		return "shoppingCart";
	}
	//生成订单
	@RequiresPermissions("order:add")
	@RequestMapping("add")
	String add(Order order,Address address,Model model,String[] order_goods_id){
		
		//System.out.println("store_id"+order.getStore_id());
		
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		String user_name = user.getSeller_login_name();
		order.setCustomer(user_name);
		order.setAddress("收件人:"+address.getAddress_contact()+",手机号:"+address.getAddress_phone()+",地址:"+address.getAddress_content());
		boolean flag = orderService.add(order,order_goods_id);
		model.addAttribute("flag", flag);
		//发送到
		
		/*//利用websocket主动向客户端发送信息
		Integer count = orderService.queryCountof0();
		
		for(WebSocketTest item: ws.getWebSocketSet()){
            try {
            	Session session = item.getSession();
            	
                item.sendMessage(count.toString());
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }*/
			//ws.sendMessage("您有100条信息需要审核");
		
		return "redirect:shoppingCart";
	}
	
	//修改订单状态
	@RequestMapping("update")
	@RequiresPermissions("order:update")
	String update(Order order,Model model){
		boolean flag = orderService.update(order);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
	//发货
	@RequestMapping("send")
	@RequiresPermissions("order:send")
	String send(Order order,Model model){
		System.out.println(order);
		boolean flag = orderService.send(order);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
}
