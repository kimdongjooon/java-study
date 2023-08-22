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

public class ChatWindow {

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
		buttonSend.addActionListener( new ActionListener() { // ActionListener인터페이스 바로 만들기.
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				sendMessage();
			}
		});
		
//		buttonSend.addActionListener((ActionEvent e) -> { // 
//			}
//		);

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode == KeyEvent.VK_ENTER) {
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
		// ChatClientThread 생성하고 실행.
	}
	private void finish() {
		// quit 프로토콜 구현.
		// exit java(JVM)
		System.exit(0);
		
		
	}
	
	private void sendMessage() { //빈 문자는 보내지말기. 
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현: "+message);
		
		textField.setText("");
		textField.requestFocus();
		
		// ChatClientThread에서 서버로부터 맞은 메시지가 있다고 생각.
		
		updateTextArea("마이콜: "+ message);
		
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
		
	}
	
	private class ChatClientThread extends Thread{

		@Override
		public void run() {
			updateTextArea("메시지.");
			sendMessage();
		}
		
	}
}
