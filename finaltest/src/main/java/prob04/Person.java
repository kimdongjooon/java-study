package prob04;

public class Person {
	 
	
	private static int numberOfPerson; // 전체 인구수
	private int age;
	private String name;
	
	
	public Person(String name) {
		this.name = name;
		this.age = 12;
		numberOfPerson++;
	}
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPerson++;
		
	}
	
	public static int getPopulation() {
		return numberOfPerson;
	}
	public void selfIntroduce() {
		System.out.printf("내 이름은 %s이며, 나이는 %d살입니다.\n",this.name, this.age);
		
	}
	
	/* 코드 작성 */
}
