package generic;

import java.util.HashMap;
import java.util.Map;

public class MapExam01 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("k1", "hello");
		map.put("k2", "하이");
		map.put("k3", "hi");
		map.put("k3", "덮어쓰기.");
		
		System.out.println(map.get("k1"));
		System.out.println(map.get("k2"));
		System.out.println(map.get("k3"));
		

	}

}
