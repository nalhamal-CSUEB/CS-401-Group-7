package serverPkg;
import java.io.*;
import java.net.*;
public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;
		communicationSystem comSystem = new communicationSystem();
		try {

			// server is listening on port 1234
			server = new ServerSocket(1234);
			server.setReuseAddress(true);

			// running infinite loop for getting
			// client request
			while (true) {

				// socket object to receive incoming client
				// requests
				Socket client = server.accept();

				// Displaying that new client is connected
				// to server
				System.out.println("New client connected"
								+ client.getInetAddress()
										.getHostAddress());

				// create a new thread object
				ClientHandler clientSock
					= new ClientHandler(client);

				// This thread will handle the client
				// separately
				new Thread(clientSock).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (server != null) {
				try {
					server.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// ClientHandler class
		private static class ClientHandler implements Runnable {
			private final Socket clientSocket;
		    private ObjectOutputStream out;
		    private ObjectInputStream in;
			// Constructor
			public ClientHandler(Socket socket) throws IOException
			{
				this.clientSocket = socket;
		        out = new ObjectOutputStream(clientSocket.getOutputStream());
		        in = new ObjectInputStream(clientSocket.getInputStream());
			}

			public void run()
			{
		        try {
		            Packet packet = (Packet) in.readObject();
		            switch (packet.getPacketType()) {
		            case "LOGIN":
		            	comSystem.login(packet.getLogin());
		            	packet.setStatus("success");
		            	switch (packet.getPacketType()) {
		            		while (true) {
					            case "LOGOUT":
					            	comSystem.logout(packet.getUser());
					            	packet.setStatus("success");
					            	out.writeObject(packet);
				            		out.flush();
					            	clientSocket.close();
					            	break;
					            case "REQUEST":
					            	switch (packet.getRequestType()) {
					            	case "SEND_MESSAGE":
					            		comSystem.writeToGroup(packet.getGroup(), packet.getMessage());
					            		//make a second enum for chats
					            		comSystem.writeToChat(packet.getChat(), packet.getMessage());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "RECEIVE_MESSAGE":
					            		packet = comSystem.readGroup();
					            		//make a second enum for chats
					            		packet = comSystem.readChat();
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "CREATE_GROUP":
					            		comSystem.addGroup(packet.getGroup())
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "CREATE_CHAT":
					            		comSystem.addChat(packet.getChat());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "JOIN_GROUP":
					            		comSystem.addUserToGroup(packet.getUser());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "LEAVE_GROUP":
					            		comSystem.removeUserFromGroup(packet.getUser());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "KICK_USER":
					            		comSystem.removeUserFromGroup(packet.getUser());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "SEND_INVITE":
					            		packet = comSystem.sendInvite(packet.getUser(), packet.getGroup());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "RECIEVE_INVITE_CONFORMATION":
					            		comSystem.addUserToGroup(packet.getUser(), packet.getGroup());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	case "REPORT_USER":
					            		//ITuser is made?
						            	break;
					            	case "BLOCK_USER":
					            		packet = comSystem.addBlockList(packet.getUser(), packet.getBlocked());
					            		packet.setStatus("success");
					            		out.writeObject(packet);
					            		out.flush();
						            	break;
					            	}
					            	break;
		            		}
		            	}
		            	break;
		            }

		         }
		         } catch (IOException | ClassNotFoundException e) {
		        	e.printStackTrace();
		        }
		}
	}
}