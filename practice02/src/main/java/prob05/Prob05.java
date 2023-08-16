package prob05;

import java.util.Random;
import java.util.Scanner;

public class Prob05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );

		while( true ) {
			
			/* 게임 작성 */

			// 정답 램덤하게 만들기
			Random random = new Random();
			int correctNumber = random.nextInt( 100 ) + 1;
			System.out.println("숫자가 결정되었습니다. 맞추어 보세요. "+correctNumber);
			int low_num =1;
			int high_num =100;
			int count = 1;
			
			while(true) {
				System.out.println(low_num+"-"+high_num);
				System.out.print(count+">>");
				int num = scanner.nextInt();
				if(low_num>num || high_num<num) {
					System.out.println("숫자 범위에서 벗어납니다. 다시 입력해주세요.");
					continue;
				}
				
				if (correctNumber == num) {
					System.out.println("맞았습니다.");
					break;
				}
				else if(correctNumber > num) {
					System.out.println("더 높게");
					low_num=num;
					count++;
				}
				else {
					System.out.println("더 낮게");
					high_num=num;
					count++;
				}
			}
			
			//새 게임 여부 확인하기
			System.out.print( "다시 하겠습니까(y/n)>>" );
			String answer = scanner.next();
			if( "y".equals( answer ) == false ) {
				break;
			}
			
		}
		
		scanner.close();
	}

}