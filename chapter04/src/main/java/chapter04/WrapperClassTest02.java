package chapter04;

public class WrapperClassTest02 {

	public static void main(String[] args) {
		String s = "123456";
		
		// 문자열을 정수형으로 바꾸기.
		int i = Integer.parseInt(s);
		
		// int형을 문자형으로 바꾸기
		String s1 = String.valueOf(i);
		String s2 = "" + i; // StringBuffer사용됨.
		
		System.out.println(s + ":" + s1 + ":"+ s2);

		int a = Character.getNumericValue('A');
		System.out.println(a);
		
		// 아스키 코드값 출력
		char c = 'c';
		System.out.println((int)'A');
		
		// 2진수 
		String s4 = Integer.toBinaryString(15);
		System.out.println(s4);
		
		// 16진수
		String s5 = Integer.toHexString(15);
		System.out.println(s5);
		
	}

}
