package cn.edu.qut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.qut.dao.MallDao;
import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Grade;
import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.Store;

@Service
public class MallService {
	@Autowired
	MallDao mallDao;
	
	public List<Store> mallStoreList(String store_name){
		return mallDao.mallStoreList(store_name);
	}
	
	public List<Goods> mallGoodsList(String store_id,String sort_id){
		return mallDao.mallGoodsList(store_id,sort_id);
	}
	
	public List<Sort> mallSortList(String store_id){
		return mallDao.mallSortList(store_id);
	}
	
	public Goods query(String goods_id){
		return mallDao.query(goods_id);
	}
	public List<Attribute> listAttribute(String goods_id){
		return mallDao.listAttribute(goods_id);
	}
	
	//查询该店铺中顾客的等级
	//首先判断有没有
	public int queryGradeExist(Grade grade){
		return mallDao.queryGradeExist(grade);
	}
	public Integer queryGrade(Grade grade){
		return mallDao.queryGrade(grade);
	}
}
