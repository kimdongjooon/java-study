package generic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class SetExam02 {

	public static void main(String[] args) {
		Set<MyData> myset = new HashSet<>();

		myset.add(new MyData("kim",500));
		myset.add(new MyData("lee",400));
		myset.add(new MyData("hong",1500));
		// set인데 동일한 객체를 선언할때 중복해서 들어간다?
		// 이는 Set이 중복체크를 hashcode()함수를 호출하여 주소로 체크하기 때문입니다.(동일성)
		// 같은 객체를 중복제거 하기위해서는 hasgcode와 equals를 오버라이드 하여 값 체크하는 것으로 변경해주어야합니다. (동질성)
		myset.add(new MyData("hong",1500)); 
		

		System.out.println("객체 길이 : " + myset.size());
//		set.get(0); 사용불가. collection은 get함수가 구현되어 있지 않음.
//      그래서 Iterator를 활용하여 꺼낼 수 있음.

		Iterator<MyData> iter = myset.iterator();
		while (iter.hasNext()) {
			MyData str = iter.next();
			System.out.println(str);
		}

	}

}

class MyData{
	private String name;
	private int value;
	
	public MyData(String name, int value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MyData [name=" + name + ", value=" + value + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode!!!");
		return Objects.hash(name, value);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals!!!");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyData other = (MyData) obj;
		return Objects.equals(name, other.name) && value == other.value;
	}
	
	
	
	
}
