package chapter04;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		// 설정한 해쉬코드 값이 같으면 중복취급함 
		Set<Rect> set = new HashSet<>();
		
		Rect r1 = new Rect(10, 20);
		Rect r2 = new Rect(10, 20);
		Rect r3 = new Rect(4, 30);
		
		set.add(r1);
		set.add(r2);
		set.add(r3);
		
		for (Rect r :set) {
			System.out.println(r);
		}
		
	}

}
