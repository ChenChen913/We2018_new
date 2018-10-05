package cn.edu.qut.tools;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import sun.misc.BASE64Decoder;

public class Tool {
	
	//获取系统当前时间 格式2017-12-26 20:52:24
	public static String getTimeNow(){
		Date d = new Date();  
        //System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(d); 
        //System.out.println(dateNowStr);
        return dateNowStr;
	}
	
	//获取系统日期
	public static String getDateNow(){
		Date d = new Date();  
        //System.out.println(d);  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d); 
        //System.out.println(dateNowStr);
        return dateNowStr;
	}
	
	//获取uuid主键
	public static String getUUID(){
		 String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象  
	     uuid = uuid.replace("-", "");               //因为UUID本身为32位只是生成时多了“-”，所以将它们去点就可  
	     //System.out.println(uuid);
	     return uuid;
	}
	
	//获取加密后的密码(用于存到数据库中，不可逆) 64位
	public static String getMD5String(String pwd) throws Exception{
		return MD5.getMD5String(pwd);
	}
	
	//生成随机密码
	public static String getRandomPassWord(int length){
		return Password.getRandomPassWord(length);
	}
	
	//发送邮件
	public static boolean sendEmail(List<String> toEmailList,String what){
		try {
			SendMail mail = eMail_ini();
			mail.setRecipients(toEmailList);
			mail.setContent(what, "text/html; charset=UTF-8");
			mail.sendMessage();
		} catch (Exception e) {
			 e.printStackTrace();
			 return false;
		}
		return true;
	}
	
	//发送邮件
	public static boolean sendEmail(String toWho,String what){
		try {
			SendMail mail = eMail_ini();
			mail.setRecipient(toWho);
			mail.setContent(what, "text/html; charset=UTF-8");
			mail.sendMessage();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//发送邮件通用固定部分封装,
	private static SendMail eMail_ini() throws Exception{
		Map<String, String> map = new HashMap<String, String>();
		SendMail mail = new SendMail("1903087169@qq.com", "tvqyrchyobmqbhfb");
		map.put("mail.smtp.host", "smtp.qq.com");
		map.put("mail.smtp.auth", "true");
		map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		map.put("mail.smtp.port", "465");
		map.put("mail.smtp.socketFactory.port", "465");
		mail.setPros(map);
		mail.initMessage();
		mail.setSubject("助微力团队");
		mail.setDate(new Date());
		mail.setFrom("管理员");
		return mail;
	}
	
	//根据base64码生成图片并保存到本地
	public static boolean GenerateImage(String imgStr, String imgFilePath){// 对字节数组字符串进行Base64解码并生成图片
	    if (imgStr == null) // 图像数据为空
	      return false;
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
	      // Base64解码
	      byte[] bytes = decoder.decodeBuffer(imgStr);
	      for (int i = 0; i < bytes.length; ++i) {
	        if (bytes[i] < 0) {// 调整异常数据
	          bytes[i] += 256;
	        }
	      }
	      // 生成jpeg图片
	      OutputStream out = new FileOutputStream(imgFilePath);
	      out.write(bytes);
	      out.flush();
	      out.close();
	      return true;
	    } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("保存到磁盘失败！");
	      
	      return false;
	    }
	  }
	
	@org.junit.Test
	public void test() {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomPassWord(i));
		}
		
	}
	
	
	public static void main(String[] args) {
		//System.out.println(getRandomPassWord(8));
		boolean flag = sendEmail("1903087169@qq.com","<div style='font-size:2em'>您好，您的的助微力账号是Yuri，您的密码是A12345，<br>请勿告诉他人并及时修改初始密码!<br>祝您工作愉快，财源滚滚！<br>助微力团队 &nbsp;竭诚为您服务</div>");
		System.out.println(flag?"发送成功！":"发送失败！");
	}
	
	
}
