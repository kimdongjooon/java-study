package chapter04;

public class WrapperClassTest01 {

	public static void main(String[] args) {
		// 직접 생성하게 되면 JVM의 힙상에 객체가 존재하게 된다.
		// 리터럴을 사용하게 되면 JVM 안의 Constant Poll이 관리한다.
		Integer i = new Integer(10);
		Character c = new Character ('c');
		Boolean b = new Boolean(true);
		
		// Auto Boxing
		Integer j1 = 10;
		Integer j2 = 20;
		
		System.out.println(j1 == j2); // 레퍼런스 값 비교. 동일성 비교 
		System.out.println(j1 < j2); // auto UnBoxing
		
//		원래 객체의값을 전달받아서 해야되지만 auto Unboxing으로 자동을 할당.
//		int m = j1.intValue() + 10;
		int m = j1 + 10; // auto Unboxing
		
		

	}

}
