package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello" + "World" + "Java" + 17;
		// 아래와같은 구조로 진행된다.
		// 문자열 합칠때는 스트링버퍼를 사용하여 붙인다.
		String s1 = new StringBuffer("Hello")
				.append("world")
				.append("Java")
				.append(17)
				.toString();
		
		System.out.println(s1);
		
		
		String s2 = "";
		// 객체를 돌릴때마다 할당된다고 시간 오래걸림.
		for(int i = 0; i < 100000;i++) {
//			s2 += i ;
//			s2 = new StringBuffer(s2).append(i).toString();
		}
		
		System.out.print(s2);
		
		// 메모리에 할당할때 시간이 오래걸린다.!!
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < 1000000 ; i ++) {
			sb.append(i);
		}
		String s3 = sb.toString();
		
		// String method들... 
		String s4 = "aBcABCabcAbc";
		
		System.out.println(s4.length()); // 문자열의 길이.
		System.out.println(s4.charAt(2)); // 문자열의 인덱스 2의 값을 반
		System.out.println(s4.indexOf("abc")); // abc문자의 첫인덱스 번호 반
		System.out.println(s4.indexOf("abc",7)); // 7인덱스부터 abc의 첫 인덱스 찾기 없으면 -1반환.
		System.out.println(s4.substring(3,5)); // 처음부터 인덱스 3부터 끝까지 
		
		String s5 = "    ab    cd    ";
		String s6 = "efg,hoj,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("---"+s5.trim()+"---"); // 양쪽 공백 제거.
		System.out.println("---"+s5.replace(" ", "")+"---"); // 모든 공백 제거 .
		
		String[] tokens = s6.split(","); // 구분자를 지정하여 문자열을나누어 배열로 저장.
		for (String t : tokens) {
			System.out.println(t);
		}
		
		String[] tokens2 = s6.split(" ");
		for (String t : tokens2) {
			System.out.println(t);
		}
	}

}
