package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		// 같은 클래스의 클래스(static) 변 접근에서는 클래스 이름 생략 가 
		m = 20;
	}
	
	void f3() {
		f1();
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
		s1();
	}
	
	// static 선언 구역에서 일반 변수 접근 불
	static void s1() {
//		에러 : static method 에서는 인스턴스 변수 접근 불가 
//		n = 30;
	}
	
	static void s2() {
//		에러 : static method 에서는 인스턴스 메소드 접근 불가 
//		f1();
	}
	
	// static 메소드 선언 구역에서 static 변수 접근가능.
	static void s3() {
		StaticMethod.m = 10;
		
//		같은 클래스의 클래스(static) 변 접근에서는 클래스 이름 생략 가능 
		m = 20;
	}
	
	static void s4() {
		StaticMethod.s1();
		
//		같은 클래스의 클래스(static) 변 접근에서는 클래스 이름 생략 가능
		s1();
	}
	
}
