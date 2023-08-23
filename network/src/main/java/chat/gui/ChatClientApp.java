package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8808;
	
	public static void main(String[] args) {
		String name = null;
		String userName = null;
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) { 
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		System.out.print("닉네임을 입력하세요 : ");
		userName =scanner.nextLine();
		
		scanner.close();
		String line = "JOIN:OK";
		System.out.println("여긴가. "+line);
		if("JOIN:OK".equals(line)) {
			new ChatWindow(name,userName).show();
		}
//		try {
//			// 1. create socket
//			socket = new Socket();
//			
//			// 2. connect server			
//			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
//			
//			// 3. writer/ reader 생성	
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
//			
//			// 4. join protocol 진행
//			pw.println("join:"+name);
//			pw.flush();
//			
//			// 5. server와의 첫번째3 통신확인. 
//			String line = "JOIN:OK";
//			System.out.println("여긴가. "+line);
//			if("JOIN:OK".equals(line)) {
//				new ChatWindow(name).show();
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			if( socket !=null && socket.isClosed()) {
//				try {
//					socket.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				
//			}
//		}
		
		
	
		 

		
	}

}
