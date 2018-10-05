package base;

import java.util.List;

public interface BaseService<T> {
	
	//增加
	boolean add(T t);
	
	//删除
	boolean delete(T t);
	
	//修改
	boolean update(T t);
	
	//查找
	T query(T t);
	List<T> list(T t);
}
