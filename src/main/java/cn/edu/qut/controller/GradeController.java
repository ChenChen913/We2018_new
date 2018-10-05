package cn.edu.qut.controller;

import java.util.List;
import java.util.Map;

import javax.swing.plaf.synth.SynthScrollBarUI;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import base.BaseController;
import cn.edu.qut.entity.Grade;
import cn.edu.qut.service.GradeService;
@RequestMapping("grade")
@Controller
public class GradeController implements BaseController<Grade>{
	@Autowired
	GradeService gradeService;

	@RequiresPermissions("grade:add")
	@RequestMapping("add")
	public String add(Grade t, Model model) {
		// TODO Auto-generated method stub
		boolean flag = gradeService.add(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("grade:delete")
	@RequestMapping("delete")
	public String delete(Grade t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = gradeService.delete(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
	@RequiresPermissions("grade:update")
	@RequestMapping("update")
	public String update(Grade t, Model model) {
		// TODO Auto-generated method stub
		//System.out.println("前台传过来的供应商信息是"+t.toString());
		boolean flag = gradeService.update(t);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}

	@RequiresPermissions("grade:query")
	@RequestMapping("query")
	public String query(Grade t, Model model) {
		// TODO Auto-generated method stub
		Grade grade = gradeService.query(t);
		model.addAttribute("grade", grade);
		return "gradeForm";
	}

	@RequiresPermissions("grade:list")
	@RequestMapping("list")
	public String list(Grade t,Model model) {
		// TODO Auto-generated method stub
		List<Grade> list= gradeService.list(t);
		//System.out.println("供应商列表是"+list);
		model.addAttribute("list", list);
		return "gradeList";
	}

	@RequiresPermissions("grade:open")
	@RequestMapping("open")
	String open(){
		return "gradeForm";
	}
	
	@RequiresPermissions("grade:saveOrUpdate")
	@RequestMapping("saveOrUpdate")
	String saveOrUpdate(Grade grade,Model model){
		//System.out.println("saveorUpdate"+grade);
		boolean flag = gradeService.saveOrUpdate(grade);
		model.addAttribute("flag", flag);
		return "redirect:list";
	}
	
	@RequiresPermissions("grade:queryCustomerByName")
	@RequestMapping("queryCustomerByName")
	@ResponseBody
	public String queryCustomerByName(String customer_login_name,Model model){
		List<Map<String,Object>> list = gradeService.queryCustomerByName(customer_login_name);
		StringBuilder s = new StringBuilder();
		for(Map<String,Object> map:list){
			//<option value='' label=''>
			s.append("<option value='");
			s.append(map.get("customer_id"));
			s.append("' label='");
			s.append(map.get("customer_login_name"));
			s.append("'>");
		}
		//System.out.println(s.toString());
		return s.toString();
	}
	
}
