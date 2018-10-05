package cn.edu.qut.dao;

import java.util.List;

import base.BaseDao;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.Supplier;

public interface GoodsDao extends BaseDao<Goods>{
	List<Sort> listSort2(Integer store_id);
	List<Supplier> listSupplier(Integer store_id);
	
}
