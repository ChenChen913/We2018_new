package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.BaseService;
import cn.edu.qut.dao.AttributeDao;
import cn.edu.qut.dao.GoodsDao;
import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Logo;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.Supplier;
import cn.edu.qut.tools.Tool;
@Service
public class GoodsService implements BaseService<Goods>{
	@Autowired
	GoodsDao goodsDao;
	
	public boolean add(Goods t) {
		// TODO Auto-generated method stub
		//获取用用户id
		//设置订单人的id
		
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		t.setSeller_id(seller.getSeller_id());
		
		//获取系统时间
		t.setGoods_start_time(Tool.getDateNow());
		
		
		//System.out.println("传的参数是==="+t.toString());
		return goodsDao.add(t);
	}

	public boolean delete(Goods t) {
		// TODO Auto-generated method stub
		return goodsDao.delete(t);
	}

	public boolean update(Goods t) {
		// TODO Auto-generated method stub
		//System.out.println("传的参数是==="+t.toString());
		return goodsDao.update(t);
	}

	public Goods query(Goods t) {
		// TODO Auto-generated method stub
		return goodsDao.query(t);
	}

	public List<Goods> list(Goods t) {
		//System.out.println("service正常");
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		t.setStore_id(seller.getStore_id());
		
		
		return goodsDao.list(t);
		
	}
	
	public List<Sort> listSort2(Integer store_id){
		return goodsDao.listSort2(store_id);
	}
	public List<Supplier> listSupplier(Integer store_id){
		return goodsDao.listSupplier(store_id);
	}
	
	public boolean logoUpload(Logo data) throws Exception{
		//接收base64编码的图片
		String strImg = data.getImg();
		//去掉前23位，标志位
		strImg = strImg.substring(23, strImg.length());
		
		boolean flag = Tool.GenerateImage(strImg, "C:\\we_file\\"+data.getLogoName());
		System.out.println(flag?"上传头像成功":"上传头像失败");
		if(flag){
			//boolean flagUpdate = storeDao.updateLogo(data.getSeller_id(),data.getLogoName());
			/*System.out.println(flagUpdate);*/
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
