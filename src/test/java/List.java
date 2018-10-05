import java.util.ArrayList;

public class List {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("2");
		
		for(String s:list){
			if(s.equals("2")){
				list.remove(s);
			}
			System.out.println(list.toString());
		}
	}
}
