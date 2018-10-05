package cn.edu.qut.controller.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Clerk_permission;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.ClerkService;
import cn.edu.qut.service.SellerService;
import cn.edu.qut.tools.Password_shiro;

@Controller
@RequestMapping("/app")
public class ClerkAndroidController {
	@Autowired
	ClerkService clerkService;
	@Autowired
	private SellerService sellerService;
	
	//查询店员
	@RequestMapping("clerlistkandroid")
	@ResponseBody
	public List<Map<String,Object>> clerkListAndroid(String user_login_name){
		//获取店员列表
		List<Map<String,Object>> list = clerkService.queryClerkBySellerName(user_login_name);
		return list;
	}
	
	
	//删除单个店员
	@RequestMapping("deloneclerkandroid")
	@ResponseBody
	public Result deleteOneClerk(String seller_id){
		boolean flag = clerkService.deleteClerkById_physics(seller_id);
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
	
	
	//删除多个店员
	@RequestMapping("dellistclerkandroid")
	@ResponseBody
	public Result deleteListClerk(String seller_ids,String usernames){
		String[] seller_id = seller_ids.split(",");
		String[] username = usernames.split(",");
		
		boolean flag = true;
		List<String> list = new ArrayList<String>();
		if(seller_id != null){
			for(int i = 0;i<seller_id.length;i++){
				if( seller_id[i].trim() != "" ){
					boolean f =  clerkService.deleteClerkById_physics(seller_id[i].trim());
					if(!f){list.add(username[i].trim());}
					flag = flag && f;
				}
			}
		}
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("删除成功");
		}else{
			result.setSuccess("true");
			result.setMessage("删除失败"+list.toString());
		}
		return result;
	}
	
	
	
	//添加店员
	@RequestMapping("addclerkandroid")
	@ResponseBody
	public Result addListClerk(Seller seller,String seller_name){
		
		boolean flag = clerkService.validate(seller.getSeller_login_name());
		Result result = new Result();
		if(!flag){
			result.setMessage("用户名已存在");
			result.setSuccess("no");
			return result;
		}
		Seller DZseller = sellerService.getSellerByUserName(seller_name);    
		seller.setStore_id(DZseller.getStore_id());
		//密码改造
		seller.setSeller_password(Password_shiro.getPasswardWithSalt(seller.getSeller_password()));
		seller.setSeller_state(DZseller.getSeller_state());
		Date d = new Date();   
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		seller.setSeller_reg_date(sdf.format(d));
		seller.setRole_id(3);
		flag = clerkService.addClerk(seller);
		if(flag){
			result.setMessage("添加成功");
			result.setSuccess("ok");
		}else{
			result.setMessage("添加失败");
			result.setSuccess("no");
		}
		return result;
	}
	
	//获取权限
	@RequestMapping("getclerperkandroid")
	@ResponseBody
	public List<Map<String,Object>> getdatePermission(String seller_id,String clerk_id){
		List<Map<String,Object>> list =  clerkService.queryClerkPermission(clerk_id,seller_id);
		System.out.println(list.toString());
		return list;
	}
	//修改权限
	@RequestMapping("upclerperkandroid")
	@ResponseBody
	public Result updatePermission(String clerk_id, String permissionid){
		
		String[] permission_id = permissionid.split(",");
		System.out.println("被授权的店员id是"+clerk_id);
		List<Clerk_permission> list = new ArrayList<Clerk_permission>();
		//System.out.println("permission_id.length="+permission_id.length);
		if(permission_id!=null){
			for(int i = 0;i<permission_id.length;i++){
				if(permission_id[i].trim() != null && permission_id[i].trim() != ""){
					Clerk_permission sp = new Clerk_permission();
					sp.setClerk_id(clerk_id);
					sp.setPermission_id(permission_id[i].trim());
					list.add(sp);
				}
			}
		}
		System.out.println("所授的权限是："+list.toString());
		
		boolean flag = clerkService.authorizeClerkByBatch(clerk_id,list);
		
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("修改成功");
		}else{
			result.setSuccess("false");
			result.setMessage("修改失败");
		}
		return result;
		
	}
	
	
}
