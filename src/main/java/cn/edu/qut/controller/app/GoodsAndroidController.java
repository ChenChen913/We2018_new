package cn.edu.qut.controller.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Store;
import cn.edu.qut.entity.app.GoodsAttr;
import cn.edu.qut.entity.app.Grade;
import cn.edu.qut.entity.app.Reperpory;
import cn.edu.qut.service.AttributeService;
import cn.edu.qut.service.GoodsService;
import cn.edu.qut.service.app.GoodsAndroidService;
import cn.edu.qut.service.app.GoodsReperporyService;
import cn.edu.qut.service.app.GradeAndroidService;
@Controller
@RequestMapping("/app")
public class GoodsAndroidController {
	@Autowired
	GoodsService goodsService;
	@Autowired
	GoodsAndroidService goodsAndroidService;
	@Autowired
	AttributeService attributeService;
	@Autowired
	GoodsReperporyService goodsReperporyService;
	@Autowired
	GradeAndroidService  gradeAndroidService;
	
	@RequestMapping("/goodslistandroid")
	@ResponseBody
	public List<Goods> getGoodsList(Goods t){
		List<Goods> goodss = goodsAndroidService.goodsList(t);
		System.out.println(goodss.toString());
		return goodss;
	}
	
	@RequestMapping("/attrlistandroid")
	@ResponseBody
	public List<Attribute> getAttributeList(Attribute attr){
		List<Attribute> attrs = attributeService.list(attr);
		System.out.println(attrs.toString());
 		return attrs;
	}
	
	@RequestMapping("/goodsrendroid")
	@ResponseBody
	public List<Reperpory> getGoodsReperpory(String store_id){
		return goodsReperporyService.selectReperpory(store_id);
	}
	

	@RequestMapping("/cutomgraderendroid")
	@ResponseBody
	public Grade getCustomerGrade(String customer_id,String store_id){
		return gradeAndroidService.findCustomGrade(customer_id, store_id);
	}
	
	@RequestMapping("/goodsandattr")
	@ResponseBody
	public List<GoodsAttr> getGoodsAndAttr(Goods goods){
		return goodsAndroidService.goodsAttr(goods);
	}
	
	
}
