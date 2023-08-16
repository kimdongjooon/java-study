package chapter04;

public class ObjectTest01 {

	public static void main(String[] args) {
		Point point = new Point();
		
//		Class myclass = point.getClass(); // reflection
//		System.out.println(myclass);
		
		System.out.println(point.getClass());
		System.out.println(point.hashCode()); // address X
											  // reference
											  // address 기반의 해싱 값 o

		System.out.println(point.toString()); // getClass() + "@" + hashCode()
		System.out.println(point); // 클래스를 호출하면 toString을 호출함.
	}

}
