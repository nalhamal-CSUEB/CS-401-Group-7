package clientPkg;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import packetPkg.Packet;
import packetPkg.PacketType;
import packetPkg.RequestType;

public class Client {

	public Socket socket;
	// driver code
		public static void main(String[] args)
		{
			// establish a connection by providing host and port
			// number
			try (Socket socket = new Socket("localhost", 1234)) {
				
				System.out.println("Connected to " + "localhost" + ":" + 1234);
				try {
					// Output stream socket.
			        OutputStream outputStream = null;
		
			        // Create object output stream from the output stream to send an object through it
			        ObjectOutputStream objectOutputStream;
			        
			        // get the input stream from the connected socket
			        InputStream inputStream = null;
		
			        // create a ObjectInputStream so we can read data from it.
			        ObjectInputStream objectInputStream;
			        
			        Packet login = new Packet(PacketType.LOGIN, StatusType.undefined, "");
			        outputStream = socket.getOutputStream();
			        objectOutputStream = new ObjectOutputStream(outputStream);
			        objectOutputStream.writeObject(login);
			        
			        inputStream = socket.getInputStream();
			        objectInputStream = new ObjectInputStream(inputStream);
			        login = (Message) objectInputStream.readObject();
			        
			        System.out.println("\nAttempting login...");
			        
			        if(login.getStatus() == StatusType.success) {
			        	System.out.println("Login successful");		        	
			        	
			        	// object of scanner class
						Scanner sc = new Scanner(System.in);
						String line = null;
						
						//text type message
						Message message = new Message(MessageType.text, StatusType.undefined, "");
						while (true) {
							System.out.println("\n\nWrite a text message. To exit, write 'logout'");
							
							// reading text from user
							line = sc.nextLine();

							// sending the user input to server
							line = line.toLowerCase();
							if(line.equals("logout")) {
								break;
							}
							message.setText(line);
							objectOutputStream.writeObject(message);
							message = (Message) objectInputStream.readObject();
							System.out.println("\nMessage Received from Server: " + message.getText() + "\n");
						}
						
						Message logout = new Message(MessageType.logout, StatusType.undefined, "");
						objectOutputStream.writeObject(logout);
						logout = (Message) objectInputStream.readObject();
						if(logout.getStatus() == StatusType.success) {
							System.out.println("\n\nLogged out successfully.");
						}
						else {
							System.out.println("\n\nThere was an error. You will be logged out");
						}
						
						// closing the scanner object
						sc.close();
						
						//close the socket.
						socket.close();
						
						//Exit out of application
						System.exit(0);
			        }
				}
				catch (IOException | ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		 

}
