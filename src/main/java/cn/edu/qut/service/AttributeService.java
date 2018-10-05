package cn.edu.qut.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.BaseService;
import cn.edu.qut.dao.AttributeDao;
import cn.edu.qut.entity.Attribute;
@Service
public class AttributeService implements BaseService<Attribute>{
	@Autowired
	AttributeDao attributeDao;
	
	public boolean add(Attribute t) {
		return attributeDao.add(t);
	}

	public boolean delete(Attribute t) {
		// TODO Auto-generated method stub
		return attributeDao.delete(t);
	}

	public boolean update(Attribute t) {
		// TODO Auto-generated method stub
		//System.out.println("传的参数是==="+t.toString());
		return attributeDao.update(t);
	}

	public Attribute query(Attribute t) {
		// TODO Auto-generated method stub
		return attributeDao.query(t);
	}

	public List<Attribute> list(Attribute t) {
		//System.out.println("service正常");
		
		return attributeDao.list(t);
		
	}
	
	public boolean addBatch(List<Attribute> list){
		return attributeDao.addBatch(list);
	}

}
