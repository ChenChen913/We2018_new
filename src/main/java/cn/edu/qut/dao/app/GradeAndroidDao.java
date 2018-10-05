package cn.edu.qut.dao.app;

import org.apache.ibatis.annotations.Param;

import cn.edu.qut.entity.app.Grade;

public interface GradeAndroidDao {
	Grade findCustomGrade(@Param("customer_id")String customer_id,@Param("store_id")String store_id);
}
