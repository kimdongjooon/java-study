package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			// 기반 스트림
			FileOutputStream fis = new FileOutputStream("hello.txt");
			
			// 보조 스트림 
			bos = new BufferedOutputStream(fis);
			
//			for (int i = 97; i <= 122; i++) 와 똑같음.
			for (int i = 'a'; i <= 'z'; i++) {// 아스키코드로 가능.
				bos.write(i);
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not Found: "+e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("error: "+e);
		}finally {
			try {
				if(bos != null) {
					bos.close();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
