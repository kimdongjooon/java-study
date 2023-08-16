package collection;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTest02 {

	public static void main(String[] args) {
		// 인터페이스. 참조
		List<String> list = new Vector<>();
		
		list.add("둘리");
		list.add("마이콜");
		list.add("도우너");
		
		// 순회 1.
		for (int i = 0 ; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		System.out.println("==========1");
		
		// 삭제.
		list.remove(2);
		
		
		// 순회 2. - iterator
		Iterator<String> it  = list.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
		System.out.println("==========2");
		
		// 순회 3. - for each문 
		// 간단하게 값만 접근 가능. 단점 인덱스를 모름.
		for (String s : list) {
			System.out.println(s);
		}
		
		
	}

}
