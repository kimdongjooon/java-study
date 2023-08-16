package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/* 코드 작성 */
		int total_num=0;
		System.out.print("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		if(num%2==1) {
			for (int i = 0;i<=num; i++) {
				if(i%2==1) {
					total_num = total_num+i;
				}
			}
		}else {
			for (int i = 0;i<=num; i++) {
				if(i%2==0) {
					total_num = total_num+i;
				}
			}
		}
		
		System.out.println(total_num);
		
		
		scanner.close();
	}
}
