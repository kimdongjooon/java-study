package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 8888;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT), 10);
			log("start server PORT:" + PORT);
			
			
	
			Socket socket = serverSocket.accept();
		
			

			try {
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();
				System.out.printf("[Echoserver] connected bv client[%s:%d]\n", remoteHostAddress, remotePort);

				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); //
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

				while (true) {
					String data = br.readLine(); // 데이터 받기.
					if (data == null)
					{
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

		} catch (IOException e) {
			log("error :" + e);

		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private static void log(String message) {
		System.out.println("[EchoServer] " + message);
	}

}
