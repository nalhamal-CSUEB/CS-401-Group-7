package serverPkg;
import java.io.*;
import java.net.*;
public class Server {

	public static void main(String[] args) {
		ServerSocket server = null;

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
		            Message message = (Message) in.readObject();
		            if (message.getType().equals("login")) {
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
