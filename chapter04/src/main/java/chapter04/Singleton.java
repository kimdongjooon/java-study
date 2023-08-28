package chapter04;

public class Singleton {
	// 객체를 한개만 생성하도록 하는것 
	private static Singleton instance;
	private Singleton() {
	}

	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}