package cn.edu.qut.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.ClerkDao;
import cn.edu.qut.entity.Clerk_permission;
import cn.edu.qut.entity.Seller;

@Service
public class ClerkService {
	@Autowired
	ClerkDao clerkDao;
	
	//根据店主用户名查找店铺中所有的店员
	public List<Map<String,Object>> queryClerkBySellerName(String seller_login_name){
		return clerkDao.queryClerkBySellerName(seller_login_name);
	}
	
	@Transactional
	public boolean addClerk(Seller seller){
		//添加用户信息，账号和密码
		//int seller_id = clerkDao.addClerk(seller_login_name, seller_password);
		int flag1 = clerkDao.addClerk(seller);
		
		//会自动将生成的自增id放入seller
		//添加店员用户角色
		//Seller_role seller_role = new Seller_role();
		//seller_role.setSeller_id(seller.getSeller_id().toString());
		//设置3号角色店员
		//seller_role.setRole_id("3");
		//seller_role.setSeller_role_state("1");
		//int flag2 = clerkDao.addClerkRole(seller_role);
		
		
		boolean flag = (flag1>0)?true:false;
		System.out.println(flag);
		return flag;
	}
	
	@Transactional
	public boolean deleteClerkById_physics(String seller_id) {
		//要先删除seller_role,然后删除 seller
		/*boolean flag_seller_role = clerkDao.deleteClerkRole_physics(seller_id);*/
		boolean flag_seller = clerkDao.deleteClerkById_physics(seller_id);
				
		return flag_seller;
	}
	
	Map<String,Object> queryClerkById(String seller_id){
		return null;
	}
	
	//校验用户名
	public boolean validate(String seller_login_name){
		int count = clerkDao.validate(seller_login_name);
		return count>0?false:true;
	}
	
	//给员工批量添加权限
	//1.员工id或者是seller_login_name
	//2.权限码的id permission_id
	public boolean authorizeClerkByBatch(String clerk_id,List<Clerk_permission> sp){
		boolean flag1 = clerkDao.deleteAllClerkPermissionById(clerk_id);
		boolean flag2 =true;
		if(!sp.isEmpty()){
			flag2 = clerkDao.authorizeClerkByBatch(sp);
		}
		return flag1 && flag2;
	}
	
	//查找店主所有的权限，
	//查找店员公共的权限
	//查找店员自定义的权限
	//最终的集合应该是，店主权限-店员公共权限    和店员自定义权限 比对
	//比较二者，加上是否具有该权限的标记
	public List<Map<String,Object>> queryClerkPermission(String clerk_id,String seller_id){
		//店员的权限集合
		//共有的店员权限
		//System.out.println("店员id是"+clerk_id);
		List<Map<String,Object>> seller_permission_list0 = clerkDao.querySellerPermission(clerk_id);
		//System.out.println("共有的店员权限"+seller_permission_list0);
		List<Map<String,Object>> clerk_permission_list = clerkDao.queryClerkPermission(clerk_id);
		//System.out.println("额外的店员的权限集合是"+clerk_permission_list.toString());
		//店主的权限集合 Map 1.permission_id  2.permission_name
		List<Map<String,Object>> seller_permission_list = clerkDao.querySellerPermission(seller_id);
		//System.out.println("店主的权限集合是"+seller_permission_list.toString());
		
		//最终的集合应该是，店主权限-店员公共权限
		Iterator<Map<String,Object>> it = seller_permission_list.iterator();
		while(it.hasNext()){
			Map<String,Object> map = it.next();
			for(Map<String,Object> map0:seller_permission_list0){
				if(map0.get("permission_id").equals(map.get("permission_id"))){
			        it.remove();
			        break;
			    }
			}
		    
		}
		for(Map<String,Object> map:seller_permission_list){
			map.put("flag", false);
			for(Map<String,Object> map_clerk:clerk_permission_list){
				if(map.get("permission_id").equals(map_clerk.get("permission_id"))){
					map.put("flag", true);
				}
			}
		}
		//System.out.println(seller_permission_list.toString());
		return seller_permission_list;
		
	}
	
	//根据用户id查找用户名
	public String selectNameByclerkID(String clerk_id){
		return clerkDao.selectNameByclerkID(clerk_id);
	}
}
