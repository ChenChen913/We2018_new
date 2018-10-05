package cn.edu.qut.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import base.BaseService;
import cn.edu.qut.dao.CustomerDao;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.tools.Tool;
import cn.edu.qut.entity.Customer;
@Service
public class CustomerService implements BaseService<Customer>{
	@Autowired
	CustomerDao customerDao;
	
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		t.setCustomer_reg_date(Tool.getTimeNow());
		return customerDao.add(t);
	}

	public boolean delete(Customer t) {
		// TODO Auto-generated method stub
		return customerDao.delete(t);
	}

	public boolean update(Customer t) {
		// TODO Auto-generated method stub
		
		return customerDao.update(t);
	}

	public Customer query(Customer t) {
		// TODO Auto-generated method stub
		return customerDao.query(t);
	}

	public List<Customer> list(Customer t) {
		// TODO Auto-generated method stub
		return customerDao.list(t);
	}
	
	public Customer getCustomerByUserName(String userName){
		return customerDao.getSellerByUserName(userName);
	}
}
