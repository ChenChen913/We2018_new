package cn.edu.qut.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Logo;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Store;
import cn.edu.qut.service.StoreService;
import cn.edu.qut.tools.Tool;
@RequestMapping("store")
@Controller
public class StoreController {
	@Autowired
	StoreService storeService;
	
	//改
	@RequiresPermissions("store:update")
	@RequestMapping("update")
	String update(Store store,Model model){
		boolean flag = storeService.update(store);
		model.addAttribute("flag", flag);
		return "redirect:/index";
	}
	//查
	@RequiresPermissions("store:query")
	@RequestMapping("query")
	String query(Model model){
		//获取用户id
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		Integer seller_id = seller.getSeller_id();
		
		Store store =storeService.query(seller_id);
		model.addAttribute("store", store);
		return "storeForm";
	}
	
	//上传头像
	 @RequestMapping("logoUpload")
	 @ResponseBody
	 Map<String,Object> logoUpload(Logo data,HttpServletRequest request){
		 String logoName = Tool.getDateNow()+Tool.getRandomPassWord(5)+".png";
		 data.setLogoName(logoName);
		 boolean flag = false;
		try {
			flag = storeService.logoUpload(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("图像失败");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", flag);
		map.put("logoName", logoName);
		return map;
	 }
}
