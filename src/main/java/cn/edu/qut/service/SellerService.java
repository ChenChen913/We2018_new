package cn.edu.qut.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.qut.dao.PermissionDao;
import cn.edu.qut.dao.RoleDao;
import cn.edu.qut.dao.SellerDao;
import cn.edu.qut.entity.Logo;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.tools.Password_shiro;
import cn.edu.qut.tools.Tool;

@Service
public class SellerService {
	@Autowired
	SellerDao sellerDao;
	
	@Autowired
	RoleDao	 roleDao;
	
	@Autowired
	PermissionDao permissionDao;
	
	
	public Seller getSellerByUserName(String userName){
		return sellerDao.getSellerByUserName(userName);
	}
	
	
	
	
	public List<Map<String, Object>> queryMenu(String seller_login_name){
		List<Map<String,?>> menu2s = permissionDao.queryMenu(seller_login_name);
		//查询店员额外的权限
		List<Map<String,?>> clerkMenuList = permissionDao.clerkMenuList(seller_login_name);
		menu2s.addAll(clerkMenuList);
		
		
		List<Map<String,Object>> menu1s = permissionDao.queryMenu1();
		for(Map<String,Object> menu1:menu1s){
			String menu1id = menu1.get("permission_id").toString();
			List<Map<String,?>> childMenu2 = new ArrayList<Map<String,?>>();
			for(Map<String,?> menu2:menu2s){
				if(menu2.get("permission_parent").toString().equals(menu1id.toString())){
					childMenu2.add(menu2);
				}
			}
			menu1.put("childNavigations", childMenu2);
		}
		
		//如果1级菜单中不包含二级菜单，则删除该一级菜单
		Iterator<Map<String,Object>> it = menu1s.iterator();
		while(it.hasNext()){
			ArrayList<Map<String,Object>> list2 = (ArrayList<Map<String, Object>>) it.next().get("childNavigations");
			if(list2.isEmpty())
				it.remove();
		}
		return menu1s;
	}
	
	
	
	
	//根据用户名查找角色
	public Set<String> findRolesByUserName(String seller_login_name){
		return new HashSet<String>(sellerDao.findRolesByUserName(seller_login_name));
	}
	

	//根据用户名查找权限
	public Set<String> findPermissionsByUserName(String seller_login_name){
		//return new HashSet(sellerDao.findPermissionsByUserName(seller_login_name));
		//System.out.println("用户名是"+seller_login_name);
		List<String> list1 = sellerDao.findPermissionsByUserName(seller_login_name);
		List<String> list2 = sellerDao.listClerkPermission(seller_login_name);
		//System.out.println("用户的list1权限是"+list1.toString());
		//System.out.println("用户的list2权限是"+list2.toString());
		list1.addAll(list2);
		//System.out.println("用户的权限是"+list1.toString());
		return new HashSet<String>(list1);
		
		
	}
	
	//增 --没有
	//删除--没有
	//修改
	public boolean update(Seller seller){
		return sellerDao.update(seller);
	}
	
	//查
	@RequiresPermissions("ddd:ddd")
	public Seller query(String seller_id){
		return sellerDao.query(seller_id);
	}
	
	public boolean logoUpload(Logo data) throws Exception{
		//接收base64编码的图片
		String strImg = data.getImg();
		//去掉前23位，标志位
		strImg = strImg.substring(23, strImg.length());
		//tomcat地址映射，图片存在了c:/WeFileUpload,使用时/we/WeFileUpload，需要在tomcat下server.xml加上一句
		//<Context path="/We/WeFileUpload" docBase="C:/WeFileUpload"></Context>
		//2017-12-31W9Gxa.png
		/*String logoName = Tool.getDateNow()+Tool.getRandomPassWord(5)+".png";*/
	
		/*//获取当前tomcat绝对路径
		String url = System.getProperty("catalina.home");
		System.out.println(url);*/
		
		
		boolean flag = Tool.GenerateImage(strImg, "C:\\we_file\\"+data.getLogoName());
		System.out.println(flag?"上传头像成功":"上传头像失败");
		if(flag){
			boolean flagUpdate = sellerDao.updateLogo(data.getSeller_id(),data.getLogoName());
			/*System.out.println(flagUpdate);*/
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean ajax_password(Seller seller){
		seller.setSeller_password(Password_shiro.getPasswardWithSalt(seller.getSeller_password()));
		Integer i = sellerDao.ajax_password(seller);
		if(i==null || i==0 ||i>1){
			return false;
		}
		else if(i==1){
			return true;
		}
		return false;
	}
	
	public boolean updateSellerPassword(Seller seller){
		seller.setSeller_password(Password_shiro.getPasswardWithSalt(seller.getSeller_password()));
		return sellerDao.updateSellerPassword(seller);
	}
	
	
}
