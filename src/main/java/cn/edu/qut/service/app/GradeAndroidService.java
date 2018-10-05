package cn.edu.qut.service.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.app.GradeAndroidDao;
import cn.edu.qut.entity.app.Grade;

@Service
public class GradeAndroidService {
	@Autowired
	GradeAndroidDao gradeAndroidDao;
	
	public Grade findCustomGrade(String customer_id,String store_id){
		return gradeAndroidDao.findCustomGrade(customer_id, store_id);
	}
	
}
