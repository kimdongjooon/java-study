package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> m= new HashMap<>();
		
		m.put("one", 1);   // auto boxing
		m.put("two", 2);
		m.put("three", 3);
		
		// 키로 값 접근하기 
		int i = m.get("one");      // auto unboxing
		int j = m.get(new String("one"));
		
		System.out.println(i+":"+j);
		
		// 기존 키에 접근하여 값 바꾸기.
		m.put("three", 3333);
		System.out.println(m.get("three"));
		
		// 순회
		Set<String> s = m.keySet();
		for(String str : s) {
			System.out.println(str);
			System.out.println(m.get(str));
		}
	}

}
