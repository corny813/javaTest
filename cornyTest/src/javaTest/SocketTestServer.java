package javaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTestServer implements Runnable {

	public static void main(String args[]) {
		new Thread(new SocketTestServer()).start();
	}

	public SocketTestServer() {
	}

	public void run() {
			try {
				ServerSocket server = new ServerSocket(18567);
				Socket socket = server.accept();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String result = br.readLine();
				
				System.out.println(result);
				
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
