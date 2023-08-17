package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListExam03 {
	// 제네릭을 사용한 자료구조 구현.
	// 따로 (String)형변환이 필요없이 String형으로 고정된 배열을 선언하였음.
	// 리스트 보다 상위 인터페이스인 Collection인터페이스로 값 저장 및 출력하기.
	public static void main(String[] args) {
		Collection<String> collection = new ArrayList(); 
		
		collection.add("kim");
		collection.add("lee");
		collection.add("hong");
		
		System.out.println("객체 길이 : "+ collection.size());
//		collection.get(0); 사용불가. collection은 get함수가 구현되어 있지 않음.
//      그래서 Iterator를 활용하여 꺼낼 수 있음.
		
		Iterator<String> iter = collection.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}
		
		
	}

}
