// File Name GreetingClient.java

import java.net.*;
import java.io.*;

public class GreetingClient {
	
	static DataFlow dataFlow = new DataFlow();
	
	public static void main(String[] args) {

		String serverName = "127.0.0.1";
		int port = 6013;
		
		boolean firstConnection = true;
		
		try {
			
			System.out.println("Connecting to " + serverName + " on port "
					+ port);
			
			while(true)
			{
			
			Socket client = new Socket(serverName, port);
			
				if(firstConnection)
				{
					System.out.println("Just connected to "
							+ client.getRemoteSocketAddress());
					firstConnection = false;
				}
			
			dataFlow.sendData(client , dataFlow.Client , dataFlow.Console , null);
			System.out.println("decrypted data: " + dataFlow.getData(client , dataFlow.Client));
			
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}




}