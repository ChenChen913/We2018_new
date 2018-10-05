package cn.edu.qut.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.qut.entity.Store;
import cn.edu.qut.entity.app.Result;
import cn.edu.qut.service.StoreService;

@Controller
@RequestMapping("/app")
public class StoreAndroidController {
	@Autowired
	StoreService storeService;
	
	@RequestMapping("/getstoreinfo")
	@ResponseBody
	public Store getStoreInfo(String seller_id){
		Store store =storeService.query(Integer.parseInt(seller_id));
		System.out.println("修改店铺信息 store :"+store.toString());
		if(store != null){
			return store;
		}else{
			return null;
		}
	}
	
	@RequestMapping("/updatestoreinfo")
	@ResponseBody
	public Result updateStoreInfo(Store store){
		boolean flag = storeService.update(store);
		Result result = new Result();
		if(flag){
			result.setSuccess("true");
			result.setMessage("修改成功");
		}else{
			result.setSuccess("true");
			result.setMessage("修改失败");
		}
		
		return result;
	}
}
