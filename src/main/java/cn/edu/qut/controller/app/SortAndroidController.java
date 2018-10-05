package cn.edu.qut.controller.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Sort;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.app.SortAndroidService;

@Controller
@RequestMapping(value="/app")
public class SortAndroidController {
	@Autowired
	SortAndroidService sortAndroidService;
	
	@RequestMapping(value="/addsortandroid")
	@ResponseBody
	public Result addSort(Sort sort){
		boolean flag = sortAndroidService.add(sort);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("添加成功");
		}else{
			result.setSuccess("true");
			result.setMessage("添加失败");
		}
		
		return result;
	}
	
	@RequestMapping(value="/delsortandroid")
	@ResponseBody
	public Result delSort(Sort sort){
		boolean flag = sortAndroidService.delete(sort);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("删除成功");
		}else{
			result.setSuccess("true");
			result.setMessage("删除失败");
		}
		
		return result;
	}
	
	@RequestMapping(value="/upsortandroid")
	@ResponseBody
	public Result updateSort(Sort sort){
		 boolean flag = sortAndroidService.update(sort);
			Result result = new Result();
			if(flag){
				result.setSuccess("true");
				result.setMessage("修改成功");
			}else{
				result.setSuccess("true");
				result.setMessage("修改失败");
			}
			System.out.println("result  :"+result.getSuccess());
			return result;
	}
	
	@RequestMapping(value="/sortlistandroid")
	@ResponseBody
	public List<Sort> sortList(Sort sort){
		 List<Sort> sortList = sortAndroidService.list(sort);
		 return sortList;	
	}
}
