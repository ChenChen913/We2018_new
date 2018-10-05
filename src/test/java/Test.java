import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

public class Test extends HashedCredentialsMatcher{
	
	public static void main(String[] args) {
		
		String pwd = "admin";
		//Object obj = new SimpleHash(s);
		//System.out.println(obj.toString());
		getDate();
		
	}
	
	//获取标准日期格式 2018-04-16
	public static void getDate() {
			Date d = new Date();  
	        //System.out.println(d);  
	        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
	        String dateNowStr = sdf.format(d);  
	        System.out.println("格式化后的日期：" + dateNowStr);  
	}
	
}
