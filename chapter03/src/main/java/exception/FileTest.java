package exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		
		
		try {
			fis = new FileInputStream("hello.txt");
			
			int data1 = fis.read();
			int data2 = fis.read();
//			System.out.println(fis.read());
			System.out.println((char)data1);
			System.out.println((char)data2);
			
		} catch (FileNotFoundException e) {
			System.out.println("error : "+e);
			
		} catch (IOException e) {
			System.out.println("error : "+e);
			
		} finally {
			try {
				if(fis != null) {
					fis.close();					
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
