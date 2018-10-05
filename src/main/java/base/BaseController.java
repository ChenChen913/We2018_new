package base;

import org.springframework.ui.Model;

public interface BaseController<T> {
	//增加
	String add(T t,Model model);
	
	//删除
	String delete(T t,Model model);
	
	//修改
	String update(T t,Model model);
	
	//查找
	String query(T t,Model model);
	String list(T t,Model model);
}
