package cn.edu.qut.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import base.BaseController;
import cn.edu.qut.entity.Goods;
import cn.edu.qut.entity.Logo;
import cn.edu.qut.entity.Order;
import cn.edu.qut.entity.Seller;
import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.Supplier;
import cn.edu.qut.service.GoodsService;
import cn.edu.qut.tools.Tool;
@RequestMapping("goods")
@Controller
public class GoodsController {
	@Autowired
	GoodsService goodsService;

	@RequiresPermissions("goods:add")
	@RequestMapping("add")
	public String add(Goods t, Model model) {
		// TODO Auto-generated method stub
		boolean flag = goodsService.add(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("goods:delete")
	@RequestMapping("delete")
	public String delete(Goods t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = goodsService.delete(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
	@RequiresPermissions("goods:update")
	@RequestMapping("update")
	public String update(Goods t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = goodsService.update(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("goods:query")
	@RequestMapping("query")
	public String query(Goods t, Model model) {
		// TODO Auto-generated method stub
		Goods goods = goodsService.query(t);
		model.addAttribute("goods", goods);
		
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		
		//查询所有的二级分类
		List<Sort> listSort2 = goodsService.listSort2(seller.getStore_id());
		model.addAttribute("listSort2", listSort2);
		
		//查询所有的供应商
		List<Supplier> listSupplier = goodsService.listSupplier(seller.getStore_id());
		model.addAttribute("listSupplier", listSupplier);
		
		return "goodsForm";
	}

	@RequiresPermissions("goods:list")
	@RequestMapping("list")
	public String list(Goods t,Model model,@RequestParam(required=true,defaultValue="1") Integer page,  
	         @RequestParam(required=false,defaultValue="5") Integer pageSize) {
		//查询未审核的
		PageHelper.startPage(page, pageSize);
		// TODO Auto-generated method stub
		List<Goods> list= goodsService.list(t);
		//System.out.println("供应商列表是"+list);
		//model.addAttribute("list", list);
		PageInfo<Goods> p = new PageInfo<Goods>(list);
		model.addAttribute("page", p);
		
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		
		//查询所有的二级分类
		List<Sort> listSort2 = goodsService.listSort2(seller.getStore_id());
		model.addAttribute("listSort2", listSort2);
		
		//查询所有的供应商
		List<Supplier> listSupplier = goodsService.listSupplier(seller.getStore_id());
		model.addAttribute("listSupplier", listSupplier);
		
		return "goodsList";
	}

	@RequiresPermissions("goods:open")
	@RequestMapping("open")
	String open(Model model){
		Seller seller = (Seller)SecurityUtils.getSubject().getPrincipal();
		
		//查询所有的二级分类
		List<Sort> listSort2 = goodsService.listSort2(seller.getStore_id());
		model.addAttribute("listSort2", listSort2);
		
		//查询所有的供应商
		List<Supplier> listSupplier = goodsService.listSupplier(seller.getStore_id());
		model.addAttribute("listSupplier", listSupplier);
		return "goodsForm";
	}
	
	//上传头像
	 @RequestMapping("logoUpload")
	 @ResponseBody
	 Map<String,Object> logoUpload(Logo data,HttpServletRequest request){
		 String logoName = Tool.getDateNow()+Tool.getRandomPassWord(5)+".png";
		 data.setLogoName(logoName);
		 boolean flag = false;
		try {
			flag = goodsService.logoUpload(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("图像失败");
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", flag);
		map.put("logoName", logoName);
		return map;
	 }
	
}
