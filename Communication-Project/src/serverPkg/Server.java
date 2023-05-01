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
		            	break;
		            case "LOGOUT":
		            	comSystem.logout((packet.getLogin());
		            	break;
		            case "REQUEST":
		            	switch (packet.getRequestType()) {
		            	case "SEND_MESSAGE":
			            	break;
		            	case "RECEIVE_MESSAGE":
			            	break;
		            	case "CREATE_GROUP":
			            	break;
		            	case "CREATE_CHAT":
			            	break;
		            	case "JOIN_GROUP":
			            	break;
		            	case "LEAVE_GROUP":
			            	break;
		            	case "KICK_USER":
			            	break;
		            	case "REPORT_USER":
			            	break;
		            	case "BLOCK_USER":
			            	break;
		            	}
		            	break;
		            }
		            if (packet.getPacketType().equals("LOGIN")) {
		                message.setStatus("success");
		                out.writeObject(message);
		                out.flush();
		                while (true) {
		                    message = (Message) in.readObject();
		                    if (message.getType().equals("text")) {
		                        message.setText(message.getText());
		                        out.writeObject(message);
		                        out.flush();
		                    } else if (message.getType().equals("logout")) {
		                        message.setStatus("success");
		                        out.writeObject(message);
		                        out.flush();
		                        clientSocket.close();
		                        break;
		                    }
		                }
		            }
		        } catch (IOException | ClassNotFoundException e) {
		        	e.printStackTrace();
		        }
			}
		}
	}
}
