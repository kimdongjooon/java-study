package chapter04;

public class ObjectTest02 {

	public static void main(String[] args) {
		//동일성, 동질성 비교
		Point p1 = new Point(10,20); // (가상) 1000번지 레퍼런스 
		Point p2 = new Point(10,20); // (가상) 2000번지 레퍼런스 
		Point p3 = p2;				 // (가상) 2000번지 레퍼런스 
		
		// 객체를 프린트할때 나오는것은 address기반 해싱값 
		
		// == : 두 객체의 동일성
		System.out.printf("p1 == p2 : %b \n", p1 == p2 ); // false
		System.out.printf("p2 == p3 : %b \n", p2 == p3 ); // true
		
		// equals : 두 객체의 동질성(내용비교) - 예상.
		// 		  : 부모 클래스 Object의 equals 기본 구현은 동일성(==) 비교와 같다.
		// 만약 내용비교하려면 오버라이딩하여 직접 구현해줘야한다.
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p3));

	}

}
