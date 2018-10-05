package cn.edu.qut.controller.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.edu.qut.service.SellerService;
import cn.edu.qut.service.app.SupplierOrderService2;
import cn.edu.qut.tools.Password;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.app.*;

@Controller
@RequestMapping(value="/app")
public class SupplierOrderController2 {
	
	@Autowired
	private SupplierOrderService2 supplierOrderService;
	
	@RequestMapping(value="/supplierorderlist")
	@ResponseBody
	public List<SupplierOrder> findAll(SupplierOrder s){
		List<SupplierOrder> sos = supplierOrderService.findAll(s);	
		return sos;
	}
	
	@RequestMapping(value="/cresupplierorderlist")
	@ResponseBody
	public Result createSupplierOrder(SupplierOrder s){
		boolean flag = true;
		List<SupplierOrder> sos = supplierOrderService.findAll(s);
		Order o = new Order();
		o.setStore_id(Integer.parseInt(s.getStore_id()));
		List<Order> orders = supplierOrderService.selectOrder(o);
		for(Order order : orders){
			supplierOrderService.updateOrderState(order);
			supplierOrderService.updateOrderGoods(order);
		}
		
		for(SupplierOrder so:sos){
			//分配订单号
			//20180503AAA 8+24=32
			Date d = new Date();  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        String str = sdf.format(d);
	        str = str.replaceAll("-", "");
			String order_number=str+Password.getRandomPassWord(24);
			so.setOrder_number(order_number);
			so.setStore_id(s.getStore_id());
			supplierOrderService.addSupplierOrder(so);
		}
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("创建成功");
		}else{
			result.setSuccess("true");
			result.setMessage("创建失败");
		}
		return result;
	}
	
	@RequestMapping(value="/ssupplierorderlist")
	@ResponseBody
	public List<SupplierOrder> findAllOrder(SupplierOrder s){
		return supplierOrderService.findAllSuOrder(s);
	}
	
	@RequestMapping(value="/upsupplierorder")
	@ResponseBody
	public Result updataSupplierOrder(SupplierOrder s){
		boolean flag = supplierOrderService.updateOrder(s);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("收货成功");
		}else{
			result.setSuccess("true");
			result.setMessage("收货失败");
		}
		return result;
	}
	
	
	
}
