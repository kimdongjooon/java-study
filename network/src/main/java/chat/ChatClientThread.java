package chat;

import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.Writer;
//import java.net.Socket;
//import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatClientThread extends Thread {
	private String nickname;
	private BufferedReader br;
	List<Writer> listWriters;
	
	public ChatClientThread(BufferedReader br,String nickname) {
		this.nickname = nickname;
		this.br = br;
	}
	
	@Override
	public void run() {
		// reader를 통해 읽은 데이터 콘솔에 출력하기 (message처리)
		try {
			
			while(true) {
				String m = br.readLine();
				if("quit".equals(m)) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				String[] tokens = m.split(":");
				if(nickname.equals(tokens[0])) {
					System.out.println(tokens[1]);
				}
				else if(tokens.length==2 && nickname != tokens[0]) {
					System.out.println(tokens[0]+" : "+tokens[1]);
				}
				else {
					System.out.println(m);
				}
				
				
			}
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
