package cn.edu.qut.shiro.filter;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.qut.entity.Seller;
import cn.edu.qut.service.SellerService;




public class WithNavibarFormAuthenticationFilter extends FormAuthenticationFilter {

	@Autowired
	private SellerService userService;
	
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {
		HttpServletRequest httpReq=(HttpServletRequest)request;
		Seller principal = (Seller)SecurityUtils.getSubject().getPrincipal();
		//System.out.println(principal);
		String userName= principal.getSeller_login_name().toString();
				//List navigationBar=userService.getNavigationBar(userName);
				List navigationBar=userService.queryMenu(userName);
		//System.out.println("导航栏菜单是"+navigationBar.toString());
		httpReq.getSession().setAttribute("navibar", navigationBar);
		return super.onLoginSuccess(token, subject, request, response);
	}
	
	

}
