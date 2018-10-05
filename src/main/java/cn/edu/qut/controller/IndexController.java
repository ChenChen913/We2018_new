package cn.edu.qut.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Seller;

@Controller
public class IndexController {
	
	//系统唯一暴露入口-登录
	@RequestMapping(value={"/","/index"})
	public String index(){
		//System.out.println("登录");
		//ModelAndView mov=new ModelAndView("index");
		
		//return mov;
		Seller user = (Seller)SecurityUtils.getSubject().getPrincipal();
		//shiro登录成功后如何获取他的登录名
		Integer role = user.getRole_id();
		//System.out.println(role);
		if(role==1 ||role==2 ||role==3){
			//是管理员
			//查询一下未审核订单的数量
			/*int count = orderService.queryCountof0();
			model.addAttribute("count", count);*/
			return "index";
		}
		else if(role==4){
			return "redirect:mall/";
		}
		return "redirect:mall/";
		
	}
	//, method = RequestMethod.POST
	@RequestMapping(value = "/a")
    @ResponseBody
    public boolean doLogin(String username, String password){

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
                System.out.println("登录成功！"+token.getCredentials());
            } catch (AuthenticationException ae) {
                System.out.println("登录失败--->" + ae.getMessage());
                return false;
            }
        }

        return true;
	}
}
