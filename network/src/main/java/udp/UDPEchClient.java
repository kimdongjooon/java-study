package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int BUFFER_SIZE = 1024; 
	
	public static void main(String[] args) {
		Scanner scanner = null;
		DatagramSocket socket = null;

		try {
			// 1. scanner 생
			scanner = new Scanner(System.in);

			// 2. UDP 소켓 생성
			socket = new DatagramSocket();

			while (true) {
				System.out.print(">");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}

				// 3. 데이터 보내기.
				byte[] sndData = line.getBytes("utf-8");

				DatagramPacket sndPacket = new DatagramPacket(
						sndData, 
						sndData.length, 
						new InetSocketAddress(SERVER_IP, 8808)
						);
				
				socket.send(sndPacket);
				
				// 받기.
				
				log("packet 수신 대기");
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(receivePacket); // Blocking
				
				byte[] rcvData = receivePacket.getData();	
				int offset = receivePacket.getLength();
				String message = new String(rcvData, 0 , offset, "utf-8");
				
				log(message);
				
			}

		} catch (SocketException e) {
			//
			System.out.println("[UDP Echo client] sudden error: " + e);
		} catch (IOException e) {
			//
			System.out.println("[client] error: " + e);
		} finally {
			
			if (scanner != null) {
				scanner.close();
			}
			if (socket != null && socket.isClosed()) {
				socket.close();
			}
			 
		}
	}
	private static void log(String message) {
		System.out.println("[UDP Echo Client] : "+message);
		
	}
	
}
