package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file = new File("phone.txt");

			// 파일 존재 확인.
			if (!file.exists()) {
				System.out.println("File Not Found");
				return;
			}

			System.out.println("===== 파일 정보 ======");
			System.out.println("파일 절대경로 : " + file.getAbsolutePath());
			System.out.println("파일 길이 : " + file.length() + "bytes");
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified())));

			// 1. 기반 스트림(file)
			FileInputStream fis= new FileInputStream(file);

			// 2. 보조스트림1 (byte|byte|byte -> char)
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

			// 3. 보조스트림2 (char1|char2|char3|\n ->"char1char2char3")
			br = new BufferedReader(isr);
			
			// 4. 처리 
			String line = null;
			while((line = br.readLine()) != null) {
//				System.out.println(line);
				// 텍스트 라인 한줄 뽑기 
				StringTokenizer st = new StringTokenizer(line, "\t ");
				
				// 한줄
				int index = 0;
				while(st.hasMoreElements()) {
					String token = st.nextToken();
					
					if(index == 0) {
						System.out.print(token + ":");
					}else if(index == 1) {// 전화번호 1.
						System.out.print(token + "-");
					}else if(index == 2) {// 전화번호 1.
						System.out.print(token + "-");
					}else {// 전화번호 1.
						System.out.print(token+"\n");
					}
					
					index++;
				}
			}
		}catch(UnsupportedEncodingException e){
			System.out.println("Error: " + e);
		}catch(IOException e) {
			System.out.println("Error: " + e);
		}finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

}
