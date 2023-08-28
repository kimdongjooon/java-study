package generic;

public class ObjectClassMain {

	public static void main(String[] args) {
		ObjectBox box = new ObjectBox();
		box.set("kim");
		String str = (String)box.get();
		System.out.println(str.toUpperCase());
		
		box.set(new Integer(5));
		Integer i = (Integer) box.get();
//		System.out.println(i.intValue());
		System.out.println(i);
		
		/* 
		 여기서 Object박스는 어떤 Object든 저장할 수 있고, 어떤 Object든 꺼낼 수 있습니다.
		 하지만 꺼낼 때는 원래 타입으로 변환 시키는 번거로운 과정이 필요합니다.
		 그래서 간단하게 사용하고자 제네릭을 활용합니다.
		*/

	}

}
