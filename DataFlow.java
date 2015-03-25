import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DataFlow {

	public static int Server = 0; // Server to Client 
	public static int Client = 1; // Client to Server
	
	public static int Console = 0;
	public static int NoConsole = 1; 
	
	CeasarCipher cipher = new CeasarCipher();

	public void sendData(Socket client, int type , int isConsole , String dataSent) throws IOException {

		OutputStream outToServer = null;
		outToServer = client.getOutputStream();
		DataOutputStream out = new DataOutputStream(outToServer);
		
		if( type == Server )
		{
			System.out.print("Server to Client: ");
		}
		
		if( type == Client )
		{
			System.out.print("Client to Server: ");
		}
		
		if(isConsole == Console)
		{
			String consoleVal = getDataFromConsole();
			System.out.println("data: " + consoleVal);
			//System.out.println("decrypted data: " + cipher.decrypt(consoleVal));
			System.out.println("----------------------------");
			System.out.println("Sending...");
			System.out.println("----------------------------");
			out.writeUTF(consoleVal);
		}
		if(isConsole == NoConsole)
		{
			System.out.println(dataSent);
			System.out.println("----------------------------");
			System.out.println("Sending...");
			System.out.println("----------------------------");
			out.writeUTF(dataSent);
		}
//		out.writeUTF(getDataFromConsole()
//				+ client.getLocalSocketAddress());

	}

	public static String getData(Socket client, int type) throws IOException {

		InputStream inFromServer = null;
		inFromServer = client.getInputStream();
		DataInputStream in = new DataInputStream(inFromServer);
		
		
		if( type == Server )
		{
			System.out.println("Receiving From Client... ");
		}
		
		if( type == Client )
		{
			System.out.println("Receiving From Server... ");
		}
		
		//System.out.println("data: " + in.readUTF());
		System.out.println("-----------------------------");
		return in.readUTF();

	}

	private static String getDataFromConsole() {

		Console cnsl = null;
		String name = null;

		try {
			// creates a console object
			cnsl = System.console();

			// if console is not null
			if (cnsl != null) {

				// read line from the user input
				name = cnsl.readLine("");

				// prints
				//System.out.println("Name entered : " + name);
			}
		} catch (Exception ex) {

			// if any error occurs
			ex.printStackTrace();
		}

		return name;

	}

}
