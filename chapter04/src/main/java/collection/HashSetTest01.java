package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> s = new HashSet<>();
		
		String s1 = new String("도우너");
		String s2 = new String("도우너");
		
		s.add("둘리");
		s.add("마이콜");
		s.add("또치");
		
		// 자료구조는 동질성으로 무조건 적용된다.(동일성 x) 값으로 따짐.
		s.add(s1);
//		s.add(s2);
		
		
		String str1 = "또치";
		s.add(str1); // 중복 제거.
		
		// Set 인터페이스 함수.
		System.out.println(s.size());
		System.out.println(s.contains(s2)); // 값기반이라서 true
		
		// 순회 
		for (String str : s) {
			System.out.println(str);
		}
	}

}
