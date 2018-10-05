package cn.edu.qut.controller.app;

import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.edu.qut.entity.Customer;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.app.SellerAndroid;
import cn.edu.qut.service.CustomerService;
import cn.edu.qut.service.SellerService;

@Controller

public class LoginAndroidController {
	
	
	@Autowired
	private SellerService sellerService;
	@Autowired
	private CustomerService customerService;
	//, method = RequestMethod.POST
	@RequestMapping(value = "/loginapp")
    @ResponseBody
    public SellerAndroid doLogin(String username, String password,String role){
		Seller seller = null;
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();

        // 测试当前的用户是否已经被认证，即是否已经登陆
        // 调用Subject的isAuthenticated
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                // 执行登陆
                currentUser.login(token);
                seller = sellerService.getSellerByUserName(username);    
                if(seller != null){
                	 Set<String> roles= sellerService.findRolesByUserName(username);
                     if(!roles.contains(role)){
                     	System.out.println(roles.toString());
                     	System.out.println(role.toString());
                     	System.out.println("角色错误");
                     	return null;
                     }
                     //获取基本信息
                     String sellerStr = JSON.toJSONString(seller);
                     SellerAndroid sellerAndroid = JSON.parseObject(sellerStr, SellerAndroid.class);
                     //获得权限列表
                     sellerAndroid.setPermisssions(sellerService.findPermissionsByUserName(username));
                     //获取图片路径
                     sellerAndroid.setSeller_img("http://192.168.43.251:8080/We2018/we_file/"+sellerAndroid.getSeller_img());      
                     System.out.println("登录成功！");
                     System.out.println(JSON.toJSONString(sellerAndroid));
                     return sellerAndroid;
                }else if(role.equalsIgnoreCase("customer")){
                	
                }
                
            } catch (AuthenticationException ae) {
                System.out.println("登录失败--->" + ae.getMessage());
                return null;
            }
        }
        return null;
	}
	
	@RequestMapping(value = "/loginappclient")
    @ResponseBody
    public Customer doLoginClient(String username, String password,String role){
		Customer customer = null;
        // 获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
//        Customer customer = customerService.getCustomerByUserName(userName);
        // 测试当前的用户是否已经被认证，即是否已经登陆
        // 调用Subject的isAuthenticated
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);
            try {
                // 执行登陆
                currentUser.login(token);
                customer = customerService.getCustomerByUserName(username);
                if(customer != null){
                     if(!role.equalsIgnoreCase("customer")){
                     	return null;
                     }
                  
                     //获取图片路径
                     customer.setCustomer_img("http://192.168.1.111:8080/We2018/we_file/"+customer.getCustomer_img());      
                     System.out.println("登录成功！");
                     System.out.println(customer.toString());
                     return customer;
                }
                
            } catch (AuthenticationException ae) {
                System.out.println("登录失败--->" + ae.getMessage());
                return null;
            }
        }
        return null;
	}
	
	
	
	
}
