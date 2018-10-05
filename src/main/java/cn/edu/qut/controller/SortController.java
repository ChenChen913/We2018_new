package cn.edu.qut.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Sort;
import cn.edu.qut.service.SortService;


@Controller
@RequestMapping("/sort")
public class SortController {
	@Autowired
	private SortService sortService;
	
	
	

	 //增
	@RequiresPermissions("sort:add")
	 @RequestMapping("add")
	 String add(Sort sort ,Model model){
		 boolean flag = sortService.add(sort);
		 model.addAttribute("flag", flag);
		 return "redirect:/sort/list";
		 
	 }
	 
	 //改
	 @RequiresPermissions("sort:update")
	 @RequestMapping("update")
	 String update(Sort sort ,Model model){
		 boolean flag = sortService.update(sort);
		 model.addAttribute("flag", flag);
		 return "redirect:/sort/list";
	 }
	 
	 //查query
	 @RequiresPermissions("sort:query")
	 @RequestMapping("query")
	 String query(Sort sort1,Model model){
		 Sort sort = sortService.query(sort1);
		 model.addAttribute("sort", sort);
		 return "sortForm";
	 }
	 
	 //查list
	 @RequiresPermissions("sort:list")
	 @RequestMapping("list")
	 String list(Sort sort,Model model){
		 //System.out.println("前台传过来的参数是"+sort.toString());
		 List<Sort> sortList = sortService.list(sort);
		 model.addAttribute("sortList", sortList);
		 return "sortList";
	 }
	 
	 //删(无)
	 @RequiresPermissions("sort:delete")
	 @RequestMapping("delete")
	String delete(Sort sort,Model model){
		boolean flag = sortService.delete(sort);
		 model.addAttribute("flag", flag);
		 return "redirect:/sort/list";
	}
	 
	 
	//打开增加form
	 @RequiresPermissions("sort:open")
	 @RequestMapping("open")
	 String open(String sort_grade,String sort_parent,String sort_parent_name,Model model){
		 /*model.addAttribute("sort_grade", sort_grade);
		 model.addAttribute("sort_parent", sort_parent);*/
		 model.addAttribute("sort_parent_name", sort_parent_name);
		 return "sortForm";
	 }
	
}
