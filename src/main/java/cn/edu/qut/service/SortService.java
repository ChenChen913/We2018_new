package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.BaseService;
import cn.edu.qut.dao.SortDao;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Sort;
@Service
public class SortService implements BaseService<Sort>{
	@Autowired
	SortDao sortDao;
	
	public boolean add(Sort t) {
		// TODO Auto-generated method stub
		//获取用用户id
		//设置订单人的id
		
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		//System.out.println("传的参数是==="+t.toString());
		return sortDao.add(t);
	}

	public boolean delete(Sort t) {
		// TODO Auto-generated method stub
		return sortDao.delete(t);
	}

	public boolean update(Sort t) {
		// TODO Auto-generated method stub
		//System.out.println("传的参数是==="+t.toString());
		return sortDao.update(t);
	}

	public Sort query(Sort t) {
		// TODO Auto-generated method stub
		return sortDao.query(t);
	}

	public List<Sort> list(Sort t) {
		//System.out.println("service正常");
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		
		/*Sort sort2 = new Sort();
		sort2.setStore_id(seller.getStore_id());*/
		
		//首先查询该店铺中所有的一级分类
		/*t.setSort_grade("1");*/
		List<Sort> list1 = sortDao.list(t);
		//System.out.println("传的参数是==="+t.toString());
		//System.out.println("查到的一级菜单是==="+list1.toString());
		
		/*for(Sort sort1:list1){
			sort2.setSort_parent(sort1.getSort_id());
			List<Sort> list2 = sortDao.list(sort2);
			sort1.setList(list2);
		}*/
		//System.out.println("所有的菜单分类是："+list1.toString());
		return list1;
		
	}

}
