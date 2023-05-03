package clientPkg;
import serverPkg.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener {
	

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
		// User chatUser = new User();

		JFrame frame;
		JPanel panel;
		
		frame = new JFrame("Chats");
		panel = new JPanel();
		frame.setSize(500, 500);		// size of frame
		frame.setLocation(500, 300);	// location on the screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		// display the frame with components
		frame.add(panel);
		
		panel.setLayout(null);

		
		// create new chat
		JButton newchatButton = new JButton("New Chat");
		newchatButton.addActionListener(this);
		newchatButton.setBounds(10, 20, 80, 50);
		panel.add(newchatButton);
		
		// exit
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(400, 20, 80, 50);
		panel.add(exitButton);
		
		//showlist of open chats
		
		
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
