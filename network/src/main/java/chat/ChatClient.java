package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8808;

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;

		
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			
			// 2. 클라이언 소켓 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			
			// 4. reader/ writer생성.
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); //
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 5. join 프로토콜
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();
			pw.println("join:"+nickname);
			pw.flush();
			
			// 6. ChatClientThread 시작
			new ChatClientThread(br, nickname).start();
			System.out.println("환영합니다. "+nickname+"님! 전체 채팅방에 입장하셨습니다.");
			// 7. 키보드 입력 처리
			while(true) {
				System.out.print(">> ");
				
				String input = scanner.nextLine();
				if(input.split(":").length>=2) {
					System.out.println(":를 두번 쓰지마세요.");
					continue;
				}
				
				// 그만두기.
				if("quit".equals(input) == true) {
					// 8. quit 프로토콜 처리
					pw.println("quit:"+input);
					pw.flush();
					break;
				}
				else {
					// 9. 메세지 처리.
					pw.println("message:"+nickname+":"+input);
					pw.flush();
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 10. 자원정리 
			scanner.close();
			try {
				if (socket != null && socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				log("error :"+e);
			}
		}

	}

	private static void log(String message) {
		System.out.println("[ChatClient] " + message);
	}
}
