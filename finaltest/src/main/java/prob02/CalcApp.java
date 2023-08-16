package prob02;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			System.out.print( "두 정수와 연산자를 입력하세요. (종료:quit)>> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 1 ] );
//			System.out.println("연산자 : "+ tokens[2]);
			
			Arithmetic arithmetic = null;
			
			/* 코드 작성 */
			if(tokens[2].equals("+")) {
				arithmetic = new Add();
			}else if(tokens[2].equals("-")) {
				arithmetic = new Sub();
			}else if(tokens[2].equals("*")) {
				arithmetic = new Mul();
			}else if(tokens[2].equals("/")) {
				arithmetic = new Div();
			}else {
				System.out.println("연산자가 존재하지 않습니다.");
			}
			
			int result = arithmetic.calculate(lValue, rValue);
			System.out.println( ">> " + result );
		}
		
		scanner.close();
	}
}