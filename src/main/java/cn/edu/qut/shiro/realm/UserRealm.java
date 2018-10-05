package cn.edu.qut.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.qut.entity.Customer;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.service.CustomerService;
import cn.edu.qut.service.SellerService;

//import cn.edu.qut.entity.User;
//import cn.edu.qut.service.UserService;



public class UserRealm extends AuthorizingRealm{

	//@Autowired
	//private UserService sellerService;
	
	@Autowired
	private SellerService sellerService;
	@Autowired
	private CustomerService customerService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("验证权限和角色");
		//String userName=(String)principals.getPrimaryPrincipal();
		Seller seller = (Seller) principals.getPrimaryPrincipal();
		String userName = seller.getSeller_login_name();
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(sellerService.findRolesByUserName(userName));
		authorizationInfo.setStringPermissions(sellerService.findPermissionsByUserName(userName));
		
		
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("登录时调用");
		String userName=(String)token.getPrincipal();
		//System.out.println(userName);
		
		Seller seller = null;
		try{
			seller = sellerService.getSellerByUserName(userName);
			//System.out.println("????seller==null="+seller);
			if(seller==null){
				Customer customer = customerService.getCustomerByUserName(userName);
				//System.out.println("customer是"+customer.toString());
				if(customer!=null){
					seller = new Seller();
					seller.setRole_id(customer.getRole_id());
					seller.setSeller_epay(customer.getCustomer_epay());
					seller.setSeller_id(customer.getCustomer_id());
					seller.setSeller_img(customer.getCustomer_img());
					seller.setSeller_login_name(customer.getCustomer_login_name());
					seller.setSeller_phone(customer.getCustomer_phone());
					seller.setSeller_real_name(customer.getCustomer_real_name());
					seller.setSeller_reg_date(customer.getCustomer_reg_date());
					seller.setSeller_state(customer.getCustomer_state());
					seller.setSeller_password(customer.getCustomer_password());
				}
				
			}
			//System.out.println(seller);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//System.out.println("顾客登录时seller还是空的吗"+seller+(null==seller));
		if(seller == null){
			//System.out.println("还是抛出了异常");
			throw new UnknownAccountException();
		}
		//System.out.println(seller.get("seller_login_name")+"+++++++++数据库密码是"+seller.get("seller_password"));
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				//seller.get("seller_login_name"),//以后将要拿取session信息的地方
				seller,
				seller.getSeller_password(),
				//ByteSource.Util.bytes(seller.getSeller_real_name()+seller.getSeller_salt()),
				ByteSource.Util.bytes("We2018"),//私钥V2UyMDE4
				getName());
		return authenticationInfo;
		
	}

}
