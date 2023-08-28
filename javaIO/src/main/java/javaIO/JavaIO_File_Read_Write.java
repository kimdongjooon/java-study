package javaIO;

import java.io.File;
import java.io.IOException;

public class JavaIO_File_Read_Write {

	public static void main(String[] args) {
		// 읽어들일 파일이없을때
//		if(args.length != 1) {
//			System.out.println("사용법 : javaIO_File_Read_Write");
//			System.exit(0);
//		} // if end
		
//		File f = new File(args[0]);
//		File f = new File("./tmp/users.dat");
		File f = new File("users.dat");
		if(f.exists()) {// 파일이 존재할 경
			System.out.println("length : "+ f.length());
			System.out.println("canRead : "+ f.canRead());
			System.out.println("canWrite : " + f.canWrite());
			System.out.println("getAbsolutePath : " + f.getAbsolutePath());
			try {
				System.out.println("getCanonicalPath : "+f.getCanonicalPath());
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println("getName : "+f.getName());
			System.out.println("getParent : "+f.getParent());
			System.out.println("getPath : " + f.getPath());
			
		}
		else { // 파일이 존재하지 않을 경우
			System.out.println("파일이 존재하지 않습니다.");
			
		}

	}

}
