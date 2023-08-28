package exception;

import java.io.IOException;

public class MyClass {
	public void danger() throws IOException, MyException {
		System.out.println("some code1 .....");
		System.out.println("some code2 .....");
		
		if(3-3 == 0) {
			throw new MyException();
		}
		
		if(1-1 == 0) {
			throw new IOException(); //해당 오류 메시지를 던진다는 의미. 던지고 코드 실행 종료.			
		}
		
		System.out.println("some code3 .....");
		System.out.println("some code4 .....");
		
	}
}
