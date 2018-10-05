package cn.edu.qut.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Customer;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.SellerService;
import cn.edu.qut.service.app.SellerAndroidService;
import cn.edu.qut.tools.Password_shiro;

@Controller
@RequestMapping(value="/app")
public class BaseInfoUpdataController {
	@Autowired
	private SellerService sellerService;
	@Autowired
	private SellerAndroidService sellerAndService;
	
	@RequestMapping(value="/baseuserinfoandroid")
	@ResponseBody
	public Result baseInfoUpdata(Seller seller){
		boolean flag = sellerService.update(seller);
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
	
	@RequestMapping(value="/passwinfoandroid")
	@ResponseBody
	public Result passwInfoUpdata(Seller seller){
		//密码改造
		seller.setSeller_password(Password_shiro.getPasswardWithSalt(seller.getSeller_password()));
		boolean flag = sellerAndService.updataPassword(seller);
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
	
	@RequestMapping(value="/userinfoclient")
	@ResponseBody
	public Result UserInfoUpdataClient(Customer customer){
		boolean flag = sellerAndService.updateClient(customer);
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
