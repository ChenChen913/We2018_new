package cn.edu.qut.service.app;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.SortDao;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Sort;

@Service
public class SortAndroidService {
	
	@Autowired
	SortDao sortDao;
	public boolean add(Sort t) {
		return sortDao.add(t);
	}

	public boolean delete(Sort t) {
		// TODO Auto-generated method stub
		return sortDao.delete(t);
	}
	
	public List<Sort> list(Sort t) {	
		List<Sort> list1 = sortDao.list(t);
		System.out.println("分类列表："+list1.toString());
		return list1;	
	}
	public boolean update(Sort t) {
		// TODO Auto-generated method stub
		//System.out.println("传的参数是==="+t.toString());
		return sortDao.update(t);
	}
}
