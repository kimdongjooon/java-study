package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatWindow {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8808;
	PrintWriter pw = null;
	
	private Frame frame;
	private String roomName;
	private String userName;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name,String userName) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.roomName = name;
		this.userName = userName;
		
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() { // ActionListener인터페이스 바로 만들기.
			@Override
			// send 버튼 눌렀을때.
			public void actionPerformed(ActionEvent actionEvent) { 
				// 내 채팅창에 띄우기.
				sendMessage(); 
				// 상대 채팅창에 띄우기.
//				sendMessage(name);
				
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				// guit창에서 엔터키 눌렀을때.
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
					
				}

			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
				finish();
			}

		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		try {
			// 1. 소켓 생성.
			Socket socket = new Socket();
			
			// 2. connect
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));

			// 3. IO스트림.
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			// ChatClientThread 생성하고 실행.
			pw.println("join:"+userName);
		
//			String name = br.readLine();
			new ChatClientThread(br, roomName,userName).start();

		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	private void finish() {
		// quit 프로토콜 구현.
		pw.println("quit");
		// exit java(JVM)
		System.exit(0);

	}

	private void sendMessage() { // 빈 문자는 보내지말기.
		String message = textField.getText();
		// 종료 
		if("quit".equals(message)) {
			pw.println("quit");
			finish();
		}
		
		System.out.println("메세지를 보내는 프로토콜 구현: " + message);

		textField.setText("");
		textField.requestFocus();

		// ChatClientThread에서 서버로부터 은 메시지가 있다고 생각.

		updateTextArea("<<"+message);
		pw.println(userName+":"+message);

	}

	private void sendMessage(String roomName) { // 빈 문자는 보내지말기.
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현: " + message);

		textField.setText("");
		textField.requestFocus();

		// chatClientThread 에서 서버로 부터 받은 메세지가 있다고 치고

		updateTextArea(userName + ": " + message);

	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");

	}

	private class ChatClientThread extends Thread {
		private String user_Name;
		private String room_Name;
		private BufferedReader br;
		List<Writer> listWriters;

		public ChatClientThread(BufferedReader br, String room_Name, String user_Name) {
			this.br = br;
			this.room_Name = room_Name;
			this.user_Name = user_Name;
		}

		@Override
		public void run() {
			// 상대방 채팅 내용 처리
			try {
				
				while(true) {
					String message = br.readLine();
					System.out.println("윈도우 메시지 받기: "+message);
					
					String[] tokens = message.split(":");
					
					if(tokens[0].equals(userName)){// 자기 채팅창에는 자기가 보낸 메시지 출력안하기.
						
					}
					else if("join".equals(tokens[0])) {
						textArea.append(tokens[1]+"\n");
					}
					
					else { // 상대방의 채팅 메시지 일때.
						textArea.append(message+"\n");
//						textField.setText(message);
							
					}
					
					
					
					
					
	
					
				}
				


			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
