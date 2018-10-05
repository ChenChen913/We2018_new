package cn.edu.qut.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.qut.dao.StoreDao;
import cn.edu.qut.entity.Logo;
import cn.edu.qut.entity.Store;
import cn.edu.qut.tools.Tool;

@Service
public class StoreService {
	@Autowired
	StoreDao storeDao ;
	
	//改
	public boolean update(Store store){
		return storeDao.update(store);
	}
	//查
	public Store  query(Integer seller_id){
		return storeDao.query(seller_id);
	}
	
	public boolean logoUpload(Logo data) throws Exception{
		//接收base64编码的图片
		String strImg = data.getImg();
		//去掉前23位，标志位
		strImg = strImg.substring(23, strImg.length());
		//tomcat地址映射，图片存在了c:/WeFileUpload,使用时/we/WeFileUpload，需要在tomcat下server.xml加上一句
		//<Context path="/We/WeFileUpload" docBase="C:/WeFileUpload"></Context>
		//2017-12-31W9Gxa.png
	
		/*//获取当前tomcat绝对路径
		String url = System.getProperty("catalina.home");
		System.out.println(url);*/
		
		
		boolean flag = Tool.GenerateImage(strImg, "C:\\we_file\\"+data.getLogoName());
		System.out.println(flag?"上传头像成功":"上传头像失败");
		if(flag){
			boolean flagUpdate = storeDao.updateLogo(data.getSeller_id(),data.getLogoName());
			/*System.out.println(flagUpdate);*/
			return true;
		}
		else{
			return false;
		}
	}
}
