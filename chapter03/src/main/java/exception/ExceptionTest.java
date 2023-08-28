package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 -a;
		
		System.out.println("some code1");
		
		try {
			
			System.out.println("some code2");
			
			int result = (1 + 2 + 3) / b;
			
			System.out.println("some code3");
			
		} catch(ArithmeticException ex) {
			ex.printStackTrace();
			// 예외 처리하기
			// 1. 로깅
			System.out.println("error: "+ ex);
			
			// 2. 사과
			System.out.println("미안합니다...");
			
			// 3. 정상종료
//			System.exit(1);
			return;
		} finally {
			System.out.println("자원정리 : file close, socket close, ..");
		}
		
		// 원칙적으로 이곳엔 코드를 두지 않는다. 
		System.out.println("some code4");
		

	}

}
