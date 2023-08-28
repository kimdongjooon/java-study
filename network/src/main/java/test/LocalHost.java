package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// 
		try {
			InetAddress inetAddress= InetAddress.getLocalHost();
			
			String hostname = inetAddress.getHostName();
			System.out.println(hostname);
			
			String hostIpAdderss = inetAddress.getHostAddress();
			System.out.println(hostIpAdderss); // 128.0.0.1 
			
			byte[] ipAddresses = inetAddress.getAddress(); //바이트로 던져줌.
			for(byte ipAddress :ipAddresses) {
				System.out.println(ipAddress & 0x000000ff);
//				System.out.println(ipAddress);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
