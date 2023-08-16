package chapter04;

public class StringTest02 {
	
	public static void main(String[] args) {
		// 불변성 (immutability)
		// 
		
		String s1 = "abc";
		String s2 = "def";
		String s3 = s2;
		System.out.println(s2);
		System.out.println(s3);
		
		s2 = s1.toUpperCase();
		String s4 = s2.concat("??");
		
		System.out.println(s2);
		System.out.println(s3);
		
		String s5 = "!".concat(s2).concat("@"); // 이건 이줄에서 쓰이고바로없어짐.  
		
		System.out.println(s5);
		
		System.out.println(equalsHello("hello"));
		System.out.println(equalsHello(null));
	}
	
	private static boolean equalsHello(String s) {
//		return s.equals("Hello"); // null 때 오류뜸.
		return "Hello".equals(s);
	}
	
}
