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
		Scanner scanner = new Scanner(System.in);
		Socket socket = null;
		
		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print("> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) { 
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		try {
			// 1. create socket
			socket = new Socket();
			
			// 2. connect server			
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			
			// 3. writer/ reader 생성	
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			
			// 4. join protocol 진행
			pw.println("join:"+name);
			pw.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( socket !=null && socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		
		
		 String line = "JOIN:OK";
		 if("JOIN:OK".equals(line)) {
			 new ChatWindow(name).show();
		 }
		

		
	}

}
