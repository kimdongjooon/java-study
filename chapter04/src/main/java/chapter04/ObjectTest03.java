package chapter04;

public class ObjectTest03 {

	public static void main(String[] args) {
		String s1 = new String("hello");
		String s2 = new String("hello");
		
		// 동일성 비교 
		System.out.println(s1==s2); // false -> toString을 호출 해쉬코드 값이 다름
		// 동질성 비교 
		System.out.println(s1.equals(s2)); // true
		
		//equal이 오버라이딩 됨.
		System.out.println(s1.hashCode() + ":" + s2.hashCode());
		
		// 원래 주소기반의 해쉬코
		System.out.println(System.identityHashCode(s1) + ":" + System.identityHashCode(s2));
		
		System.out.println("======================");
		
		String s3 = "hello";
		String s4 = "hello";
		
		System.out.println(s3==s4); 
		System.out.println(s3.equals(s4)); 
		System.out.println(s3.hashCode() + ":" + s4.hashCode());
		System.out.println(System.identityHashCode(s3) + ":" + System.identityHashCode(s4));
		

	}

}
