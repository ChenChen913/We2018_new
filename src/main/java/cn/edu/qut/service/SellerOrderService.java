package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.SellerOrderDao;
import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.OrderGoods;
import cn.edu.qut.entity.Seller;

@Service
public class SellerOrderService {
	@Autowired
	SellerOrderDao sellerOrderDao;
	
	//查询店铺中所有的商品
	public List<Goods> list(Goods goods){
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		goods.setStore_id(seller.getStore_id());
		List<Goods> list = sellerOrderDao.list(goods);
		for(Goods goods_:list){
			List<Attribute> attributeList = sellerOrderDao.listAttribute(goods_.getGoods_id());
			goods_.setAttributeList(attributeList);
		}
		return list;
	}
	
	/*@Transactional*/
	public boolean add(Order order){
		
		boolean flag1 = sellerOrderDao.add(order);
		for(OrderGoods t:order.getOrderGoodsList()){
			t.setOrder_id(order.getOrder_id());
		}
		boolean flag2 = sellerOrderDao.addOrderGoods(order.getOrderGoodsList());
		return flag1&&flag2;
		
	}
}
