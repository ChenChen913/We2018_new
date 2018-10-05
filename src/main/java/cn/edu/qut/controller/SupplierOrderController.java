package cn.edu.qut.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.SupplierOrder;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.SupplierOrderService;
import cn.edu.qut.tools.Password;

@Controller
@RequestMapping(value="/supplierOrder")
public class SupplierOrderController {
	
	@Autowired
	private SupplierOrderService supplierOrderService;
	
	@RequestMapping(value="/list")
	public String findAll(SupplierOrder s,Model model){
		List<SupplierOrder> list = supplierOrderService.findAll(s);
		model.addAttribute("list", list);
		return "supplierOrderList";
	}
	
	@RequestMapping(value="/add")
	public String createSupplierOrder(SupplierOrder s,Model model){
		boolean flag = true;
		List<SupplierOrder> sos = supplierOrderService.findAll(s);
		Order o = new Order();
		List<Order> orders = supplierOrderService.selectOrder(o);
		for(Order order : orders){
			supplierOrderService.updateOrderState(order);
			supplierOrderService.updateOrderGoods(order);
		}
		
		for(SupplierOrder so:sos){
			//分配订单号
			//20180503AAA 8+24=32
			Date d = new Date();  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
	        String str = sdf.format(d);
			
			String order_number=str+Password.getRandomPassWord(24);
			so.setOrder_number(order_number);
			so.setStore_id(s.getStore_id());
			supplierOrderService.addSupplierOrder(so);
		}
		/*Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("创建成功");
		}else{
			result.setSuccess("true");
			result.setMessage("创建失败");
		}
		return result;*/
		model.addAttribute("flag", flag);
		return "redirect:list0";
	}
	
	@RequestMapping(value="/list0")
	public String findAllOrder(SupplierOrder s,Model model){
		s.setOrder_state("1");
		List<SupplierOrder> list1 =  supplierOrderService.findAllSuOrder(s);
		model.addAttribute("list1", list1);
		s.setOrder_state("2");
		List<SupplierOrder> list2 =  supplierOrderService.findAllSuOrder(s);
		model.addAttribute("list2", list2);
		return "supplierOrderList0";
	}
	
	@RequestMapping(value="/update")
	public String updataSupplierOrder(SupplierOrder s,Model model){
		boolean flag = supplierOrderService.updateOrder(s);
		model.addAttribute("flag", flag);
		
		return "redirect:list0";
	}
	
	
	
}
