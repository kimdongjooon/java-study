package chapter03;

public class StudentTest2 {

	public static void main(String[] args) {
		Student s = new Student();
		
		Person p = s; // upcasting(암시적, Implicity)
		
		Student s2 = (Student)p; // downcasting(명시적, Explicity)
	}

}
