package generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExam01 {

	public static void main(String[] args) {
		Set<String> set = new HashSet();

		set.add("kim");
		set.add("lee");
		set.add("hong");
		set.add("hong");

		System.out.println("객체 길이 : " + set.size());
//		set.get(0); 사용불가. collection은 get함수가 구현되어 있지 않음.
//      그래서 Iterator를 활용하여 꺼낼 수 있음.

		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}

	}

}
