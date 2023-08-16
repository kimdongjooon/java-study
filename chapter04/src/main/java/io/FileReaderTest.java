package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {
	public static void main(String[] args) {
		Reader in =null;
		InputStream is = null;
		
		
		
		try {
			// 글자 단위로 읽기. - char 단위
			in = new FileReader("test.txt");
			
			int count = 0;
			int data = -1;
			
			while((data= in.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			
			System.out.println("\ncount : "+ count);
			System.out.println("=====================1");
			
			count = 0;
			data = -1;
			
			// byte 단위로 읽기 3개단위로 읽어야 글자가 나옴. 하지만 1개씩 읽어서 깨짐.
			is = new FileInputStream("test.txt");
			while((data = is.read()) != -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println("\ncount : "+ count);
			System.out.println("=====================2");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) {
					in.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
