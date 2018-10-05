package cn.edu.qut.dao.app;

import java.util.List;

import cn.edu.qut.entity.app.Reperpory;

public interface GoodsReperporyDao {
	List<Reperpory> selectReperpory(String store_id);
	
}	
