package generic;

import java.util.ArrayList;
import java.util.List;

public class ListExam02 {
	// 제네릭을 사용한 자료구조 구현.
	// 따로 (String)형변환이 필요없이 String형으로 고정된 배열을 선언하였음.
	public static void main(String[] args) {
//		ArrayList<String> list = new ArrayList(); // 같은 클래스 타입으로 하면안좋음.
		List<String> list = new ArrayList(); // 참조하는 인터페이스인 List를 사용하여 코드를 작성하도록 한다.
		
		list.add("kim");
		list.add("lee");
		list.add("hong");
		
		String str1 = list.get(0);
		String str2 = list.get(1);
		String str3 = list.get(2);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
		
	}

}
