import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Test_password {
	public static void main(String args[]){
		RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
		String algorithmName = "md5";//算法名
		int hashIterations = 2;//迭代次数
		
		//String s = randomNumberGenerator.nextBytes().toHex();
		//System.out.println(s+"==="+s.length());//32为随机数
		//String s2 = randomNumberGenerator.nextBytes().toHex();
		//System.out.println(s2+"==="+s2.length());//32为随机数
		
		
		//String pwd = new SimpleHash(算法,内容,盐,迭代次数).toString();
//		String pwd = new SimpleHash(algorithmName,"1","1").toString();
//		String pwd2 = new SimpleHash(algorithmName,"2","1").toHex();
//		String pwd3 = new SimpleHash(algorithmName,"1","6559",2).toString();
//		System.out.println(pwd);
//		System.out.println(pwd2);
//		System.out.println(pwd3);
		//System.out.println(ByteSource.Util.bytes("admin"+"84012b1f7ab582eb1a0eb46ed08fb5a9"));
		//String pwd = new SimpleHash("md5","dianzhu1",ByteSource.Util.bytes("dianzhu184012b1f7ab582eb1a0eb46ed08fb5a9"),2).toHex();
		System.out.println(ByteSource.Util.bytes("We2018"));
		//System.out.println(ByteSource.Util.bytes("We2018"));
		String pwd = new SimpleHash("md5","dianzhu1","We2018",2).toHex();//私钥We2018
		System.out.println(pwd.equals("4f4222c611efde98f54aa084973474b4"));
		System.out.println(pwd);//System.out.println("1637fcf8b38df9216beeab1ee78cabb8".equals(pwd));
	}
	
	public static String getPwd(String pwd){
		String pwd2 = new SimpleHash("md5",pwd,"Yuri").toHex();
		return pwd2;
	}
}
