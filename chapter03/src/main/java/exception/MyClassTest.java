package exception;

import java.io.IOException;

public class MyClassTest {

	public static void main(String[] args) {
		
		try {
			MyClass myClass = new MyClass();
			myClass.danger();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (MyException e) {
//			e.printStackTrace();
		} catch (Exception e) { // 예외 처리 한곳에서 할수있음. 즉 모든 예외처리하고 싶을때 사용.
			e.printStackTrace();
		}
		
	}

}
