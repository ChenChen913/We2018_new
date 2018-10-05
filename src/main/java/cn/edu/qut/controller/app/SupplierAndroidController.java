package cn.edu.qut.controller.app;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Supplier;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.SupplierService;
import cn.edu.qut.service.app.SupplierAndroidService;

@Controller
@RequestMapping("/app")
public class SupplierAndroidController {
	
	@Autowired
	SupplierAndroidService supplierService;
	
	//获取供应商列表
	@RequestMapping("/getsuplistandriod")
	@ResponseBody
	public List<Supplier> getSupplierList(Supplier t){
		List<Supplier> list= supplierService.list(t);
		return list;
	}
	//获得供应商详细信息
	@RequestMapping("/getsupandroid")
	@ResponseBody
	public Supplier getSupplier(Supplier t){
		Supplier supplier = supplierService.query(t);
		return supplier;
	}
	//添加供应商
	@RequestMapping("/addsupndroid")
	@ResponseBody
	public Result addSupplier(Supplier t){
		boolean flag = supplierService.add(t);
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
	//删除供应商
	@RequestMapping("/deletesupndroid")
	@ResponseBody
	public Result deleteSupplier(Supplier t){
		boolean flag = supplierService.delete(t);
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
	
	//修改供应商信息
	@RequestMapping("/updatasupndroid")
	@ResponseBody
	public Result updataSupplier(Supplier t){
		boolean flag = supplierService.update(t);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("修改成功");
		}else{
			result.setSuccess("true");
			result.setMessage("修改失败");
		}
		
		return result;
	}
	
}
