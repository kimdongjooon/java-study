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

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
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
				// gui창에서 엔터키 눌렀을때.
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
			ServerSocket serverSocket = new ServerSocket();

			// 2. 바인딩.
			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT));

			// 3. accept
			Socket socket = serverSocket.accept();

			// 4. IO스트림.
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			// ChatClientThread 생성하고 실행.
			String name = br.readLine();
			new ChatClientThread(br, name).start();

		} catch (IOException e1) {

			e1.printStackTrace();
		}

	}

	private void finish() {
		// quit 프로토콜 구현.
		// exit java(JVM)
		System.exit(0);

	}

	private void sendMessage() { // 빈 문자는 보내지말기.
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현: " + message);

		textField.setText("");
		textField.requestFocus();

		// ChatClientThread에서 서버로부터 은 메시지가 있다고 생각.

		updateTextArea(message);

	}

	private void sendMessage(String name) { // 빈 문자는 보내지말기.
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현: " + message);

		textField.setText("");
		textField.requestFocus();

		// ChatClientThread에서 서버로부터 은 메시지가 있다고 생각.

		updateTextArea(name + ": " + message);

	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");

	}

	private class ChatClientThread extends Thread {
		private String name;
		private BufferedReader br;
		List<Writer> listWriters;

		public ChatClientThread(BufferedReader br, String name) {
			this.name = name;
			this.br = br;
		}

		@Override
		public void run() {
			try {
				
				while(true) {
					String message = br.readLine();
					textField.setText(message);
					sendMessage(name);
					
	
					
				}
				


			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
