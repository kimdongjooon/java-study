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
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatWindow {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int PORT = 8808;
	Socket socket = null;
	PrintWriter pw = null;
	BufferedReader br = null;
	
	private Frame frame;
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
				finish();
			}

		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		try {
			// 1. 소켓 생성.
			socket = new Socket();
			
			// 2. connect
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));

			// 3. IO스트림.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);

			// ChatClientThread 생성하고 실행.
			pw.println("join:"+userName);
		
			
			new ChatClientThread(br, userName).start();

		} catch (IOException e1) {

			e1.printStackTrace();
		} finally {
			try {
				if(socket !=null && socket.isClosed()) {
					socket.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			finish();
		}else {
			System.out.println("메세지를 보내는 프로토콜 구현: " + message);

			textField.setText("");
			textField.requestFocus();

			// ChatClientThread에서 서버로부터 은 메시지가 있다고 생각.
			
			if(!"".equals(message)) { // 아무것도 안보내면 출력 x
				updateTextArea("<<"+message);
				pw.println(userName+":"+message);
			}
			
		}
		
		

	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");

	}

	private class ChatClientThread extends Thread {
		private BufferedReader br;
		private String user_Name;

		public ChatClientThread(BufferedReader br, String user_Name) {
			this.br = br;
			this.user_Name = user_Name;
		}

		@Override
		public void run() {
			try {
				
				while(true) {
					String message = br.readLine();
					System.out.println("윈도우 메시지 받기: "+message);
					
					String[] tokens = message.split(":");
					
					if(tokens[0].equals(user_Name)){
						// 자기 채팅창에는 자기가 보낸 메시지 출력안하기.
					}
					else if("join".equals(tokens[0])) { // 채팅방 입장 메시지.
						textArea.append(tokens[1]+"\n");
					}
					else { // 상대방의 채팅 메시지 일때.
						textArea.append(message+"\n");
					}
										
				}
				


			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
