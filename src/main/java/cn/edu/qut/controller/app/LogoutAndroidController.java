package cn.edu.qut.controller.app;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.app.SellerAndroid;
import cn.edu.qut.service.SellerService;

@RequestMapping(value = "/app")
@ResponseBody
public class LogoutAndroidController {
	@RequestMapping(value = "/logoutandroid",method = RequestMethod.POST)
	public void doLogout(String username, String password,String role){
	    Subject currentUser = SecurityUtils.getSubject();
	    currentUser.logout(); 
	}
}
