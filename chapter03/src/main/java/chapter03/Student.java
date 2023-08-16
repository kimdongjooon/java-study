package chapter03;

public class Student extends Person {
	public Student() {
		// 모든 자식생성자에서 부모 생성자를 명시적으로 호출하지 않으면 
		// super()라는 부모의 기본 생성자를 자식생성자 코드 맨 앞 호출.
		super(); // 부모 기본 생성자 호출 
		System.out.println("Student() called");
	}

}
