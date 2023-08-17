package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print(">> ");
			String line = scanner.nextLine();
			
			if("quit".equals(line)) {
				break;
			}
			
			try {
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);
				
				for(InetAddress inetAddress : inetAddresses) {
					System.out.println(inetAddress.getHostName()+" : "+inetAddress.getHostAddress());
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
				
			
			
			
		}
	}

}
