// File Name GreetingServer.java

import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
	
	CeasarCipher cipher = new CeasarCipher();
	DataFlow dataFlow = new DataFlow();
	private ServerSocket serverSocket;

	public GreetingServer(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}

	boolean isConnected = true;
	boolean firstConnection = true;
	
	public void run() {
		while (isConnected) {

			try {
				
				Socket server = serverSocket.accept();

				if(firstConnection)
				{
					System.out.println("Waiting for client on port "
							+ serverSocket.getLocalPort() + "...");
					System.out.println("Just connected to "
							+ server.getRemoteSocketAddress());
					firstConnection = false;
				}
				
				String gettingData = null;
				
				gettingData = dataFlow.getData(server , dataFlow.Server);
				
				System.out.println("data: " + gettingData);
				System.out.println("decrypted data: " + cipher.decrypt(gettingData));
				
				dataFlow.sendData(server , dataFlow.Server , dataFlow.NoConsole , cipher.decrypt(gettingData));
				
				//server.close();
				//isConnected = false;
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public static void main(String[] args) {
		try {
			Thread t = new GreetingServer(6013);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}