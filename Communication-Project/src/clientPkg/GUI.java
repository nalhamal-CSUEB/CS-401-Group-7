package clientPkg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.*;

public class GUI implements ActionListener {
	JButton newchatButton;
	JPanel chatpanel;
	JFrame chatframe;		

	public GUI() {
		JFrame frame;
		JPanel panel;
		// frame
		
		frame = new JFrame("Login");
		panel = new JPanel();
		frame.setSize(350, 150);		// size of frame
		frame.setLocation(500, 300);	// location on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//to close the frame
		frame.add(panel);
		
		panel.setLayout(null);

		// username label
		JLabel userLabel = new JLabel("Username");  // Username label
		userLabel.setBounds(10, 20, 80, 25);		// location on the frame
		panel.add(userLabel);		//add label
		
		// username text box
		JTextField userText = new JTextField(20); 	// Username text box
		userText.setBounds(100, 20, 165, 25);		// location of box
		panel.add(userText);		// add text box 
		
		// password label
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		// password text box
		JPasswordField passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setBounds(10, 80, 80, 25);
		panel.add(cancelButton);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		loginButton.setBounds(100, 80, 80, 25);
		panel.add(loginButton);
		
	
		frame.setVisible(true);		// display the frame with components
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] commands = { "Chats", "Groups", "Invites", "Exit" };

		int choice;

		choice = JOptionPane.showOptionDialog(null, "Select a command", "Home",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, commands,
				commands[commands.length - 1]);		// last variable is what is selected so thats 
													// why i can use int choice, prints list in reverse order
		
		switch (choice) {
			case 0:
				doChats();
				break;
			case 1:
				doGroups();
				break;
			case 2:
				doInvites();
				break;
			case 3:
				doExit();
				break;
			default: // do nothing
			
		}
	}

	private void doChats() {
		Client client = new Client();
		Socket s = client.socket;
		ObjectInputStream din = new ObjectInputStream(s.getInputStream());
		ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());
		//client.socket.getOutputStream();
	
			
		
		chatframe = new JFrame("Chats");
		chatpanel = new JPanel();
		chatframe.setSize(500, 500);		// size of frame
		chatframe.setLocation(500, 500);	// location on the screen
		chatframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatframe.setVisible(true);		// display the frame with components
		chatframe.add(chatpanel);
		
		
		chatpanel.setLayout(null);

		
		// create new chat
		newchatButton = new JButton("New Chat");
		newchatButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) {
				JFrame newchatFrame;
				JPanel newchatPanel;
				
				newchatFrame = new JFrame("Chat");
				newchatPanel = new JPanel();
				newchatFrame.setSize(500, 500);		// size of frame
				newchatFrame.setLocation(300, 300);	// location on the screen
				newchatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				newchatFrame.setVisible(true);		// display the frame with components
				newchatFrame.add(newchatPanel);
				
				newchatPanel.setLayout(null);

				JTextField text = new JTextField();
				text.setBounds(5, 400, 300, 40);
				text.setVisible(true);
				newchatPanel.add(text);
				
				JTextArea textArea = new JTextArea();
				textArea.setBounds(10, 10, 420, 350);
				textArea.setVisible(true);
				newchatPanel.add(textArea);
				
				JButton send = new JButton("Send");
				send.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						// send and display messages
						String fieldText = text.getText();
						textArea.setText(fieldText);
						String msgin = "";
						try {
							while(!msgin.equals("logout")) {
								msgin = (String)din.readObject();
								textArea.setText(textArea.getText().trim() + "\n Server: " + msgin);
							}
						}catch(Exception e) {
							
						}
					}
				}
				);
				send.setBounds(310, 400, 150, 40);
				newchatPanel.add(send);

			
			}
		}
		);
		
		newchatButton.setBounds(10, 20, 80, 50);
		chatpanel.add(newchatButton);
		
		// exit
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(400, 20, 80, 50);
		chatpanel.add(exitButton);
		
		//show list of open chats
		
		
	}
	private void doGroups() {
		JFrame frame;
		frame = new JFrame("Groups");
		frame.setSize(500, 500);		// size of frame
		frame.setLocation(500, 300);	// location on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);		// display the frame with components
	}
	private void doInvites() {
		JFrame frame;
		frame = new JFrame("Invites");
		frame.setSize(500, 500);		// size of frame
		frame.setLocation(500, 300);	// location on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		frame.setVisible(true);		// display the frame with components
	}
	private void doExit() {
	}
	public static void main(String[] args) {
		new GUI();
	}
}
