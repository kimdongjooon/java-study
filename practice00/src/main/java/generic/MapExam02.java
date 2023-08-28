package generic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapExam02 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("k1", "hello");
		map.put("k2", "하이");
		map.put("k3", "hi");
		map.put("k3", "덮어쓰기.");
		
		
		Set<String> keySet = map.keySet();
		// 향상된 for문으로 출력가능.
		for(String key : keySet) {
			System.out.println(map.get(key));
		}
		// 상위 인터페이스인 iterator로 출력가능
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = map.get(key);
			
			System.out.println(key + ":" + value);
		}
		

	}

}
