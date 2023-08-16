package javaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaIO_Keybord_Input {
	/* 
	 자바 IO란?
	 자바를 활용하여 파일 입출력을 하는것
	 입력은 키보드, 네트워크, 파일 등으로 부터 받을 수 있다.
	 출력은 화면, 네트워크, 파일등에 할 수 있다.
	 */
	
	public static void main(String[] args) throws Exception{
		// 키보드 : System.in
		// 환면 출력 : System.out
		// 키보드로 입력 받는건 문자를 입력 받는것 : char단위로 입출력
		// char단위 입출력 클래스는 Reader, Writer
		// 한줄 읽기 Readline() > 읽을게 없으면 null리턴. - 장
		// 한줄 쓰기 : PrintStream, PrintWriter 
		
		// BufferedReader x
		// CharReader x - 문자로부터 읽어 들인다
		// FilterReader x - 장식 Reader를 넣어줘야한다.
		// InputStreamReader(InputStream in) - 	장식
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = null;
		try {
			while( (line = br.readLine()) != null) {
				System.out.println("입력값 : "+ line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
