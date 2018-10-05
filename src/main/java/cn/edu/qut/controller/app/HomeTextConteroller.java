package cn.edu.qut.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Store;
import cn.edu.qut.service.AttributeService;
import cn.edu.qut.service.MallService;

@Controller
@RequestMapping(value = "/app")
public class HomeTextConteroller {
	@Autowired
	MallService mallService;
	
	@Autowired
	AttributeService attributeService;
	
	@RequestMapping(value = "/homeandroid",method = RequestMethod.POST)
    @ResponseBody
	public String getHomeText(){
		String str = new String("欢迎使用助微力app，助微力开发团队祝您心想事成、财源广进");
		return str;
	} 
	
	
	//根据店铺名模糊查询店铺
	@RequestMapping(value = "/homeandclient",method = RequestMethod.POST)
    @ResponseBody
	public List<Store> getHomeTextClient(String storename){
		List<Store> list = mallService.mallStoreList(storename);
		return list;
	} 
	
}
