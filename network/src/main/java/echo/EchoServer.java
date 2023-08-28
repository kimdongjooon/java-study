package echo;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
	private static final String SERVER_IP = "192.168.0.128";
	public static final int PORT = 8888;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress(SERVER_IP, PORT), 10);
			log("start server PORT:" + new InetSocketAddress(SERVER_IP, PORT));

			while (true) {
				Socket socket = serverSocket.accept();
				new EchoRequestHandler(socket).start();
			}

		} catch (IOException e) {
			log("error :" + e);

		} finally {
			try {
				if (serverSocket != null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String message) {
		System.out.println("[EchoServer#"+Thread.currentThread().getId() +"] " + message);
	}

}
