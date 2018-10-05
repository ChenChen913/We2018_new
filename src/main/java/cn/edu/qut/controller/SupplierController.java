package cn.edu.qut.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import base.BaseController;
import cn.edu.qut.entity.Supplier;
import cn.edu.qut.service.SupplierService;
@RequestMapping("supplier")
@Controller
public class SupplierController implements BaseController<Supplier>{
	@Autowired
	SupplierService supplierService;

	@RequiresPermissions("supplier:add")
	@RequestMapping("add")
	public String add(Supplier t, Model model) {
		// TODO Auto-generated method stub
		System.out.println("t="+t.toString());
		boolean flag = supplierService.add(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("supplier:delete")
	@RequestMapping("delete")
	public String delete(Supplier t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = supplierService.delete(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
	@RequiresPermissions("supplier:update")
	@RequestMapping("update")
	public String update(Supplier t, Model model) {
		// TODO Auto-generated method stub
		System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = supplierService.update(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("supplier:query")
	@RequestMapping("query")
	public String query(Supplier t, Model model) {
		// TODO Auto-generated method stub
		Supplier supplier = supplierService.query(t);
		model.addAttribute("supplier", supplier);
		return "supplierForm";
	}

	@RequiresPermissions("supplier:list")
	@RequestMapping("list")
	public String list(Supplier t,Model model) {
		// TODO Auto-generated method stub
		List<Supplier> list= supplierService.list(t);
		//System.out.println("供应商列表是"+list);
		model.addAttribute("list", list);
		return "supplierList";
	}

	@RequiresPermissions("supplier:open")
	@RequestMapping("open")
	String open(){
		return "supplierForm";
	}
	
	
}
