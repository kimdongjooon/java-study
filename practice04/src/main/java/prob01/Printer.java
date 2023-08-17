package prob01;

public class Printer {
	
	// 일반적인 오버로딩.
//	public void println(int i) {
//		System.out.println(i);
//	}
//	
//	public void println(boolean b) {
//		System.out.println(b);
//	}
//	
//	public void println(double d) {
//		System.out.println(d);
//	}
//	
//	public void println(String str) {
//		System.out.println(str);
//	}
	
	// 제너릭으로 사용하기 - 밑의 오브젝트로 구현한 메소드와 동일함 그래서 같이선언불가. 
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	// 오브젝트로 사용하기  
//	public void println(Object o) {
//		System.out.println(o);
//	}
	
	public <T> void println(T... ts) {
		for (T t : ts) {
			System.out.println(t);
		}
		
	}
	
	// 가변 파라미터 
	public int sum(Integer... nums) {
		int s =0;
		for(Integer i : nums) {
			s +=i;
		}
		return s;
	}
}
