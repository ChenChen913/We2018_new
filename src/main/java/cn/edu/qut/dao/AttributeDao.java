package cn.edu.qut.dao;


import java.util.List;

import base.BaseDao;
import cn.edu.qut.entity.Attribute;

public interface AttributeDao extends BaseDao<Attribute>{
	
	boolean addBatch(List<Attribute> list);
	
	
	
}
