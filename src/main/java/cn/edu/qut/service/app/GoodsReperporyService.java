package cn.edu.qut.service.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.qut.dao.app.GoodsReperporyDao;
import cn.edu.qut.entity.app.Reperpory;

@Service
public class GoodsReperporyService {
	@Autowired
	GoodsReperporyDao goodsReperporyDao;
	
	public List<Reperpory> selectReperpory(String store_id){
		return goodsReperporyDao.selectReperpory(store_id);
	}
}
