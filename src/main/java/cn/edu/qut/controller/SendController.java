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


@RequestMapping("send")
@Controller

public class SendController {
	@Autowired
	OrderService orderService;
	

	@RequiresPermissions("send:list")
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
		
		return "orderSendList";
	}
	
	
	
	//修改订单状态
	@RequestMapping("update")
	@RequiresPermissions("send:update")
	String update(Order order,Model model){
		boolean flag = orderService.send(order);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
}
