package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	
	// 1. 스레드의 인스턴스 변수.
	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	
	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
		
	}
	
	PrintWriter printWriter = null;
	BufferedReader bufferedReader  = null;
	
	// 2. 요청처리를 위한 Loop 작성.
	// - run 메소드 오버라이딩.
	@Override
	public void run() {
		//1. Remote Host Information
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		System.out.printf("[ChatServer] connected by client[%s:%d]\n", remoteHostAddress, remotePort);
		
		
		try {
			//2 . 스트림 얻기.
			bufferedReader = new BufferedReader(new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			
			//3. 요청 처리
			while(true) {
				String request = bufferedReader.readLine();
				if(request == null) {
					log("클라이언트로 부터 연결 끊김.");
					break;
				}
				
				// 프로토콜 분석
				String[] tokens = request.split(":");
				if("join".equals(tokens[0])) {
					System.out.println("join 실행.");
					doJoin(tokens[1],printWriter);
				}
				else if("message".equals(tokens[0])) {
					System.out.println("message 실행 -> "+tokens[1]+" : "+tokens[2]);
					doMessage(tokens[1]+":"+tokens[2]);
				}
				else if("quit".equals(tokens[0])) {
					System.out.println("quit 실행.");
					doQuit(printWriter);
				}
				else {
					ChatServer.log("error: 알수 없는 요청("+tokens[0]+")");
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
		
	}

	private void removeWriter(Writer writer) {
		synchronized(listWriters) { // 동일성 검사로 빼내기.
			for (int i = 0; i<listWriters.size();i++) {
				if(writer == listWriters.get(i)) {
					listWriters.remove(i);
					printWriter.println("quit");
					break;
				}
			}
		}
		
	}

	private void doMessage(String message) {
		broadcast(message);
		
		
	}

	// join 프로토콜 구현.
	private void doJoin(String nickName, Writer Writer) {
		this.nickname = nickName;
		
		String data = nickName + "님이 참여하였습니다.";
		broadcast(data);
		
		// writer pool에 저장.
		addWriter(Writer);
		
		// ack
		printWriter.flush();
		
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void broadcast(String data) {
		synchronized(listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	
	private void log(String message) {
		System.out.println("[ChatServerThread#"+getId()+"] "+message);
	}
	
	
	
}
