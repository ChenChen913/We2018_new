package cn.edu.qut.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import base.BaseDao;
import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Grade;
import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.Store;

public interface MallDao extends BaseDao<Store>{
	List<Store> mallStoreList(String store_name);
	
	List<Goods> mallGoodsList(@Param("store_id")String store_id,@Param("sort_id")String sort_id);
	
	List<Sort> mallSortList(String store_id);
	
	Goods query(String goods_id);
	
	List<Attribute> listAttribute(String goods_id);
	
	//查询该店铺中顾客的等级
	//首先判断有没有
	int queryGradeExist(Grade grade);
	Integer queryGrade(Grade grade);
}
