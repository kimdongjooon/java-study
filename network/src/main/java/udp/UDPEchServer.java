package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPEchServer {
	private static final int PORT = 8808;
	private static final int BUFFER_SIZE = 1024;
	
	public static void main(String[] args) {
		DatagramSocket datagramSocket = null;
		
		try {
			// 1. UDP소켓 생성.
			datagramSocket = new DatagramSocket(PORT);
			
			while(true) {
				// 2. 수신 대기.
				log("packet 수신 대기");
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				datagramSocket.receive(receivePacket); // Blocking
				
				byte[] rcvData = receivePacket.getData();	
				int offset = receivePacket.getLength();
				String message = new String(rcvData, 0 , offset, "utf-8");
				
				log(message);
				
				// 3. 송신
				byte[] sndData = message.getBytes("utf-8");
				
				DatagramPacket sndPacket = new DatagramPacket(
						sndData, 
						sndData.length,
						receivePacket.getAddress(),
						receivePacket.getPort()); 
				datagramSocket.send(sndPacket);
			}
		} catch (SocketException e) {
			log("error : "+e);
		} catch (IOException e) {
			log("error : "+e);
		} 
		
		finally {
			if(datagramSocket != null && !datagramSocket.isClosed()) {
				datagramSocket.close();
			}
		}

	}
	
	private static void log(String message) {
		System.out.println("[UDP Echo Server] : "+message);
		
	}

}
