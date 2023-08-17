package generic;

public class GenericBoxMain {

	public static void main(String[] args) {
		// 원하는 타입을 가진 객체로 사용할 수 있습니다.
		// 장점. 정해진 타입으로만 강제하여 잘못된 타입값이 저장되는 것을 막을 수 있습니다.
		GenericBox<String> strBox = new GenericBox<>();
		strBox.set("kim");
		String str = strBox.get();
		System.out.println(str);
		
		GenericBox<Integer> intBox = new GenericBox<>();
		intBox.set(5);
		int i = intBox.get();
		System.out.println(i);
	}

}
