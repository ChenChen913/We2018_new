package cn.edu.qut.tools;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Password_shiro {
	
	public static String getPasswardWithSalt(String password) {
		//私钥We2018
		String passwardWithSalt = new SimpleHash("md5",password,"We2018",2).toHex();
		return passwardWithSalt;
	}
	
	public static void main(String[] args) {
		String s = getPasswardWithSalt("1111");
		System.out.println(s);
	}
}
