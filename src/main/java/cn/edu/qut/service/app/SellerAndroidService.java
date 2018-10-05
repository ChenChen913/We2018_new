package cn.edu.qut.service.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.CustomerDao;
import cn.edu.qut.dao.app.SellerAndroidDao;
import cn.edu.qut.entity.Customer;
import cn.edu.qut.entity.Seller;
@Service
public class SellerAndroidService {
	@Autowired
	SellerAndroidDao sellerDao;
	@Autowired
	CustomerDao customerDao;
	
	
	public boolean updataPassword(Seller seller){
		
		return sellerDao.updataPassword(seller);
	}
	
	public boolean updateClient(Customer t){
		return customerDao.update(t);
	}
}
