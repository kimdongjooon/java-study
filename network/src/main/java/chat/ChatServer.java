package chat;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8808;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<>();
		
		try {
			// 1. 서버 소켓 생성.
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
//			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			log("start ChatServer : "+SERVER_IP+":"+PORT);
			
			// 3. accept
			while (true) {
				Socket socket = serverSocket.accept();
				PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
				new ChatServerThread(socket,listWriters).start();
			}
			
			
		} catch (IOException e) {
			log("error : "+e);
			
		} finally {
			
				try {
					if (serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
					}
				} catch (IOException e) {
					log("error :"+e);
				}
			}
		

	}
	
	public static void log(String message) {
		System.out.println("[ChatServer"+Thread.currentThread().getId() +"] : " + message);
	}

}
