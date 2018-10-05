package cn.edu.qut.dao;


import base.BaseDao;
import cn.edu.qut.entity.Customer;

public interface CustomerDao extends BaseDao<Customer>{
	Customer getSellerByUserName(String username);
}
