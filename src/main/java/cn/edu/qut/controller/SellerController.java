package cn.edu.qut.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.qut.entity.Logo;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.service.SellerService;
import cn.edu.qut.tools.Tool;

/*import com.test.entity.User;
import com.test.service.PasswordService;
import com.test.service.RoleService;
import com.test.service.UserService;*/

@Controller
@RequestMapping("/user")
public class SellerController {
	@Autowired
	private SellerService sellerService;
	
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req){
		String error=null;
		
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(ExcessiveAttemptsException.class.getName().equals(exceptionClassName)) {
            error = "登陆太过频繁，请稍后重试";
        }else if(exceptionClassName != null) {
        	//System.out.println(exceptionClassName);
            error = "其他错误：" + exceptionClassName;
        }
        //System.out.println("error"+error);
        ModelAndView mav=new ModelAndView("login");
        mav.addObject("error", error);
		return mav;
        //return "login";
	}
	
	
	
	//增 --没有
	//删除--没有
	//修改
	@RequiresPermissions("seller:update")
	@RequestMapping("update")
	String update(Seller seller,Model model){
		//System.out.println(seller.toString());
		boolean flag = sellerService.update(seller);
		model.addAttribute("flag", flag);
		return "redirect:query";
	}
	
	//查
	@RequiresPermissions("ddd:ddd")
	@RequestMapping("query")
	String query(Model model){
		Seller seller0 = (Seller)SecurityUtils.getSubject().getPrincipal();
		Integer user_id = seller0.getSeller_id();
		Seller seller = sellerService.query(user_id.toString());
		model.addAttribute("seller", seller);
		return "SellerForm";
	}
	
	//上传头像
	 @RequestMapping("logoUpload")
	 @ResponseBody
	 Map<String,Object> logoUpload(Logo data,HttpServletRequest request){
		/*System.out.println(data.toString());*/
		 String logoName = Tool.getDateNow()+Tool.getRandomPassWord(5)+".png";
		 data.setLogoName(logoName);
		 boolean flag = false;
		/* //文件保存路径
       String fileName = request.getSession().getServletContext().getRealPath("upload");  
       System.out.println(fileName);*/
		try {
			 flag = sellerService.logoUpload(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("图像失败");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", flag);
		map.put("logoName", logoName);
		return map;
	 }
	
	 
	 //打开修改密码
	 @RequiresPermissions("ddd:ddd")
	 @RequestMapping("password")
	 String password(Model model){
		Seller seller0 = (Seller)SecurityUtils.getSubject().getPrincipal();
		Integer user_id = seller0.getSeller_id();
		Seller seller = sellerService.query(user_id.toString());
		model.addAttribute("seller", seller);
		return "sellerPassword";
	}
	 
	 //检验原来的密码
	 @RequestMapping("ajax_password")
	 @ResponseBody
	 boolean ajax_password(Seller seller){
		 //用户id
		 //用户密码要传
		 return sellerService.ajax_password(seller);
	 }
	 
	 //修改密码
	@RequestMapping("updateSellerPassword")
	String updateSellerPassword(Seller seller){
		boolean flag = sellerService.updateSellerPassword(seller);
		if(flag){
			//退出
			return "redirect:/logout";
		}
		return "redirect:/password";
	}
	
	
	
}
