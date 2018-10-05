package cn.edu.qut.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Clerk_permission;
import cn.edu.qut.service.ClerkService;
import cn.edu.qut.service.SellerService;
import cn.edu.qut.tools.Password_shiro;

@Controller
@RequestMapping("/clerk")
public class ClerkController {
	@Autowired
	ClerkService clerkService;
	
	@Autowired
	SellerService sellerService;
	
	//查询所有的店员,不能给它传任何参数，传参数不安全
	@RequiresPermissions("clerk:list")
	@RequestMapping("/list")
	String queryClerksByStoreId(Model model){
		
		//当前用户凭证
		Seller principal = (Seller)SecurityUtils.getSubject().getPrincipal();
		String user_login_name = principal.getSeller_login_name();
		//获取店员列表
		List<Map<String,Object>> list = clerkService.queryClerkBySellerName(user_login_name);
		//System.out.println("店员有="+list);
		model.addAttribute("clerkList", list);
	
		//获取权限值
		List<Map<String, Object>> permissionList= sellerService.queryMenu(principal.getSeller_login_name());
		model.addAttribute("permissionList",permissionList);
		return "clerk-list";
	}
	
	//添加店员
	@RequiresPermissions("clerk:add")
	@RequestMapping("/add")
	String addClerk(Seller seller){
		
		//当前用户凭证
		Seller principal = (Seller)SecurityUtils.getSubject().getPrincipal();
		//System.out.println(principal.toString());
		//System.out.println(seller.toString());
		//填充数据
		seller.setStore_id(principal.getStore_id());
		//密码改造
		seller.setSeller_password(Password_shiro.getPasswardWithSalt(seller.getSeller_password()));
		seller.setSeller_state(principal.getSeller_state());
		
		Date d = new Date();   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
        String dateNowStr = sdf.format(d); 
        
		seller.setSeller_reg_date(dateNowStr);
		seller.setRole_id(3);
		
		clerkService.addClerk(seller);
		
		return "redirect:/clerk/list";
	}
	
	@RequestMapping("deleteClerkById_physics")
	String deleteClerkById_physics(String seller_id){
		//System.out.println(seller_id);
		boolean flag = clerkService.deleteClerkById_physics(seller_id);
		
		return "redirect:/clerk/list";
	}
	
	//验证seller_login_name是否重复
	@ResponseBody
	@RequestMapping("validate")
	Boolean validate(String seller_login_name){
		return clerkService.validate(seller_login_name);
	}
	
	//给员工
	@RequestMapping("authorizeClerkByBatch")
	public String authorizeClerkByBatch(String clerk_id,String[] permission_id){
		
		//System.out.println("被授权的店员id是"+clerk_id);
		
		List<Clerk_permission> list = new ArrayList<Clerk_permission>();
		//System.out.println("permission_id.length="+permission_id.length);
		if(permission_id!=null){
			for(int i = 0;i<permission_id.length;i++){
				Clerk_permission sp = new Clerk_permission();
				sp.setClerk_id(clerk_id);
				sp.setPermission_id(permission_id[i]);
				list.add(sp);
			}
		}
		
		//System.out.println("所授的权限是："+list.toString());
		
		boolean flag = clerkService.authorizeClerkByBatch(clerk_id,list);
		return "redirect:/index";
	}
	
	@RequestMapping("queryClerkPermission")
	String queryClerkPermission(String clerk_id,Model model){
		model.addAttribute("clerk_id", clerk_id);
		String clerk_login_name = clerkService.selectNameByclerkID(clerk_id);
		model.addAttribute("clerk_login_name", clerk_login_name);
		//当前用户凭证
		Seller principal = (Seller)SecurityUtils.getSubject().getPrincipal();
		String seller_id = principal.getSeller_id().toString();
		List<Map<String,Object>> list = clerkService.queryClerkPermission(clerk_id,seller_id);
		model.addAttribute("list", list);
		return "clerk-permission";
	}
	
}
