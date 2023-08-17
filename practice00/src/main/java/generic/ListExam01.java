package generic;

import java.util.ArrayList;

public class ListExam01 {
	// 자료구조객체들은 제네릭을 사용하지 않으면 Object 타입을 저장.
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); 
		
		list.add("kim");
		list.add("lee");
		list.add("hong");
		
		String str1 = (String)list.get(0);
		String str2 = (String)list.get(1);
		String str3 = (String)list.get(2);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		
	}

}
