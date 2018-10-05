package cn.edu.qut.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import base.BaseController;
import cn.edu.qut.entity.Attribute;
import cn.edu.qut.service.AttributeService;
@RequestMapping("goods")
@Controller
public class AttributeController implements BaseController<Attribute>{
	@Autowired
	AttributeService attributeService;

	

	@RequiresPermissions("goods:attributedelete")
	@RequestMapping("attributedelete")
	public String delete(Attribute t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = attributeService.delete(t);
		model.addAttribute("flag", flag);
		return "redirect:attributelist?goods_id="+t.getGoods_id();
	}
	
	@RequiresPermissions("goods:attributeupdate")
	@RequestMapping("attributeupdate")
	public String update(Attribute t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = attributeService.update(t);
		model.addAttribute("flag", flag);
		return "redirect:attributelist?goods_id="+t.getGoods_id();
	}

	@RequiresPermissions("goods:attributequery")
	@RequestMapping("attributequery")
	public String query(Attribute t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("query的goods_id="+t.getGoods_id());
		Attribute attribute = attributeService.query(t);
		model.addAttribute("attribute", attribute);
		
		return "attributeForm";
	}

	@RequiresPermissions("goods:attributelist")
	@RequestMapping("attributelist")
	public String list(Attribute t,Model model) {
		// TODO Auto-generated method stub
		List<Attribute> list= attributeService.list(t);
		//System.out.println("供应商列表是"+list);
		model.addAttribute("list", list);
		model.addAttribute("goods_id", t.getGoods_id());
		return "attributeList";
	}

	@RequiresPermissions("goods:attributeopen")
	@RequestMapping("attributeopen")
	String open(Model model,String goods_id){
		//System.out.println("open里goods_id"+goods_id);
		model.addAttribute("goods_id", goods_id);
		return "attributeForm";
	}
	
	//批量添加商品属性
	@RequiresPermissions("goods:attributeopen")
	@RequestMapping("attributeopenBatch")
	String attributeopenBatch(Model model,String goods_id){
		//System.out.println("open里goods_id"+goods_id);
		model.addAttribute("goods_id", goods_id);
		return "attributeFormBatch";
	}
	
	@RequiresPermissions("goods:attributeadd")
	@RequestMapping("attributeadd")
	public String add(Attribute t, Model model) {
		//System.out.println("添加传过来的参数是："+t.toString());
		// TODO Auto-generated method stub
		boolean flag = attributeService.add(t);
		model.addAttribute("flag", flag);
		return "redirect:attributelist?goods_id="+t.getGoods_id();
	}
	
	@RequiresPermissions("goods:attributeadd")
	@RequestMapping("attributeaddBatch")
	public String addBatch(String attribute_color[],String attribute_size[],Attribute t, Model model) {
		List<Attribute> list = new ArrayList<Attribute>();
		for(int i=0;i<attribute_color.length;i++){
			for(int j=0;j<attribute_size.length;j++){
				String s = attribute_color[i]+attribute_size[j];
				//System.out.println(s);
				//
				Attribute tt = null;
				try {
					tt = (Attribute) t.clone();
					tt.setAttribute_name(s);
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				list.add(tt);
			}
		}
		//System.out.println(list.toString());
		boolean flag = attributeService.addBatch(list);
		model.addAttribute("flag", flag);
		return "redirect:attributelist?goods_id="+t.getGoods_id();
		
	}
	
}
