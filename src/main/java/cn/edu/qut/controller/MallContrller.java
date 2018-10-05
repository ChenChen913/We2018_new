package cn.edu.qut.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.edu.qut.entity.Attribute;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Grade;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.Store;
import cn.edu.qut.service.AttributeService;
import cn.edu.qut.service.MallService;
@SessionAttributes("sortlist")
@Controller
@RequestMapping("mall")
public class MallContrller {
	@Autowired
	MallService mallService;
	
	@Autowired
	AttributeService attributeService;
	
	@RequestMapping(value={"/","index"})
	String index(){
		return "mallList";
	}
	
	@RequestMapping("storeList")
	String mallStoreList(String store_name, Model model){
		List<Store> list = mallService.mallStoreList(store_name);
		model.addAttribute("list", list);
		return "mallList";
	}
	@RequestMapping("list")
	String list(String store_id,String sort_id, Model model){
		List<Goods> goodslist = mallService.mallGoodsList(store_id,sort_id);
		model.addAttribute("goodslist", goodslist);
		
		model.addAttribute("store_id", store_id);
		
		List<Sort> sortlist = mallService.mallSortList(store_id);
		model.addAttribute("sortlist", sortlist);
		
		//System.out.println("調用了goodsList，sortlist"+sortlist);
		return "mallGoodsList";
	}
	
	@RequestMapping("query")
	String query(String goods_id,String store_id, Model model){
		Goods goods = mallService.query(goods_id);
		model.addAttribute("goods", goods);
		
		model.addAttribute("store_id", store_id);
		
		List<Attribute> listAttribute = mallService.listAttribute(goods_id);
		model.addAttribute("listAttribute", listAttribute);
		
		Grade grade = new Grade();
		grade.setStore_id(Integer.parseInt(store_id));
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		grade.setCustomer_id(seller.getSeller_id());
		Integer grade_type = mallService.queryGrade(grade);
		if(grade_type==null){
			grade_type = 1;
		}
		//System.out.println("该用户的等级是:"+grade_type);
		model.addAttribute("grade_type", grade_type);
		
		return "mallGoodsForm";
	}

}
