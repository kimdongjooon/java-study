package chat.gui;

import java.util.Scanner;

public class ChatClientApp {
	
	public static void main(String[] args) {
		String name = null;
		String userName = null;
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			
			System.out.print("대화명을 입력하세요 : ");
			name = scanner.nextLine();
			
			System.out.print("닉네임을 입력하세요 : ");
			userName =scanner.nextLine();
			
			if (name.isEmpty() == false ) { 
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		
		scanner.close();
		
		// 스레드 실행.
		new ChatWindow(name,userName).show();
		
		
	}

}
