package chat.gui;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ChatServerApp {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8808;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<>();
		
		try {
			// 1. Server socket 생성.
			serverSocket = new ServerSocket();
			
			// 2. bind
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));
			log("start ChatServer : "+SERVER_IP+":"+PORT);
			
			// 3. accept
			while (true) {
				Socket socket = serverSocket.accept();
				new ChatServerAppThread(socket,listWriters).start();
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
		System.out.println("[ChatServerApp#"+Thread.currentThread().getId() +"] : " + message);
	}
}
