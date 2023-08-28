package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerAppThread extends Thread {
	
	// 1. 스레드의 인스턴스 변수.
		private String name;
		private Socket socket;
		List<Writer> listWriters;
		
		public ChatServerAppThread(Socket socket, List<Writer> listWriters) {
			this.socket = socket;
			this.listWriters = listWriters;
			
		}
		
		PrintWriter pw = null;
		BufferedReader br  = null;

		@Override
		public void run() {
			
			try {
				// 2. 스트림 얻기.
				br = new BufferedReader(new InputStreamReader( socket.getInputStream(), StandardCharsets.UTF_8));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
				
				
				// 3. 요청처리 - join, message,
				while(true) {
					String request = br.readLine(); // 데이터 받기
					log("request data : "+request);
					
					// 클라이언트로부터 연결 끊김.
					if(request == null) {
						log("클라이언트로부터 연결 끊김.");
						break;
					}
					
					// 요청 데이터 처리. - join 처리.
					String[] tokens = request.split(":");
					if("join".equals(tokens[0])){
						log("join 실행.");
						pw.print("join:");
						doJoin(tokens[1],pw);
					}
					
					else if("quit".equals(tokens[0])) {
						System.out.println("quit 실행.");
						doQuit(pw);
					}
					else {
						System.out.println("message 실행 -> "+request);
						doMessage(request);

					}
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (NullPointerException e) {
				log("error: "+e);
			}
		
		}
		private void doQuit(Writer writer) {
			removeWriter(writer);
			
			String data = name + "님이 퇴장하였습니다.";
			broadcast(data);
			
		}
		
		private void removeWriter(Writer writer) {
			synchronized(listWriters) { // 동일성 검사로 빼내기.
				for (int i = 0; i<listWriters.size();i++) {
					if(writer == listWriters.get(i)) {
						listWriters.remove(i);
						pw.println("quit");
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
			this.name = nickName;
			
			// writer pool에 저장.
			String data = nickName + "님이 참여하였습니다.";
			addWriter(Writer);
			broadcast(data);
			
			// ack
			pw.flush();
			
		}
		
		private void addWriter(Writer writer) {
			synchronized(listWriters) {
				listWriters.add(writer);
			}
		}
		
		private void broadcast(String data) {
			System.out.println("listWriters 크기. :"+listWriters.size());
			synchronized(listWriters) {
				for (Writer writer : listWriters) {
					PrintWriter printWriter = (PrintWriter)writer;
					printWriter.println(data);
					System.out.println("send!");
					printWriter.flush();
				}
			}
		}
		
		private void log(String message) {
			System.out.println("[ChatServerAppThread#"+getId()+"] "+message);
		}
		
		
}
