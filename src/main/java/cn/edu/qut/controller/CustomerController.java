package cn.edu.qut.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import base.BaseController;
import cn.edu.qut.entity.Customer;
import cn.edu.qut.service.CustomerService;
@RequestMapping("customer")
@Controller
public class CustomerController implements BaseController<Customer>{
	@Autowired
	CustomerService customerService;

	/*@RequiresPermissions("customer:add")*/
	@RequestMapping("add")
	public String add(Customer t, Model model) {
		// TODO Auto-generated method stub
		boolean flag = customerService.add(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("customer:delete")
	@RequestMapping("delete")
	public String delete(Customer t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = customerService.delete(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
	@RequiresPermissions("customer:update")
	@RequestMapping("update")
	public String update(Customer t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = customerService.update(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("customer:query")
	@RequestMapping("query")
	public String query(Customer t, Model model) {
		// TODO Auto-generated method stub
		Customer customer = customerService.query(t);
		model.addAttribute("customer", customer);
		return "customerForm";
	}

	@RequiresPermissions("customer:list")
	@RequestMapping("list")
	public String list(Customer t,Model model) {
		// TODO Auto-generated method stub
		List<Customer> list= customerService.list(t);
		//System.out.println("供应商列表是"+list);
		model.addAttribute("list", list);
		return "customerList";
	}

	@RequiresPermissions("customer:open")
	@RequestMapping("open")
	String open(){
		return "customerForm";
	}
	
	@RequestMapping("register")
	String register(){
		return "register";
	}
	
}
