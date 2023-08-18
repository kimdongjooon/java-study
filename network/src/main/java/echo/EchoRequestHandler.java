package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoRequestHandler extends Thread {
	private Socket socket;
	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
		String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
		int remotePort = remoteInetSocketAddress.getPort();
		System.out.printf("[Echoserver] connected bv client[%s:%d]\n", remoteHostAddress, remotePort);
		
		try {
			

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); //
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			while (true) {
				String data = br.readLine(); // 데이터 받기.
				if (data == null) {
					log("closed by clinet");
					break;
				}

				log("received: " + data);
				pw.println(data); // 데이터 보내기.

			}

		} catch (SocketException e) {
			log("suddenly closed by client");
		} catch (IOException e) {
			log("error :" + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		super.run();
	}
	
	private void log(String message) {
		System.out.println("[EchoServer#"+ getId() + "] " + message);
	}


	
}
