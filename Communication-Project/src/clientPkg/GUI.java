package clientPkg;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener {
	JPanel chatPanel;
	JPanel groupPanel;
	JFrame chatFrame;
	JFrame groupFrame;


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
//		cancelButton.addActionListener(new ActionListener() { 
//			public void actionPerformed(ActionEvent event) {
//				System.exit(0);
//			}
//		});
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
		chatFrame = new JFrame("Chats");
		chatPanel = new JPanel();
		chatFrame.setSize(500, 500);		// size of frame
		chatFrame.setLocation(500, 500);	// location on the screen
		chatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chatFrame.setVisible(true);		// display the frame with components
		chatFrame.add(chatPanel);
		
		
		chatPanel.setLayout(null);

		
		// create new chat
		JButton newchatButton;
		newchatButton = new JButton("New Chat");
		newchatButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) {
				JFrame newchatFrame;
				JPanel newchatPanel;
				
				newchatFrame = new JFrame("Chat");
				newchatPanel = new JPanel();
				newchatFrame.setSize(500, 500);		// size of frame
				newchatFrame.setLocation(300, 300);	// location on the screen
				//newchatFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
						// send and display messages on frame
						String fieldText = text.getText();
						textArea.setText(fieldText);
					}
				});
				send.setBounds(310, 400, 150, 40);
				newchatPanel.add(send);
			}
		}
		);
		
		newchatButton.setBounds(10, 20, 80, 50);
		chatPanel.add(newchatButton);
		
		// exit
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(this);
		exitButton.setBounds(400, 20, 80, 50);
		chatPanel.add(exitButton);
		
		//show list of open chats
		
		
	}
	private void doGroups() {
		groupFrame = new JFrame("Groups");
		groupPanel = new JPanel();
		groupFrame.setSize(500, 500);		// size of frame
		groupFrame.setLocation(500, 300);	// location on the screen
		groupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		groupFrame.setVisible(true);		// display the frame with components
		groupFrame.add(groupPanel);
		
		groupPanel.setLayout(null);

		JButton newgroupButton, publicgroupButton, mygroupsButton, homeButton;
		newgroupButton = new JButton("New Group");
		newgroupButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame selectedgroupFrame;
				JPanel selectedgroupPanel;
				JButton joinButton, leaveButton, writeButton, groupButton;
				
				selectedgroupFrame = new JFrame("Selected Group");
				selectedgroupPanel = new JPanel();
				selectedgroupFrame.setSize(500, 500);		// size of frame
				selectedgroupFrame.setLocation(300, 300);	// location on the screen
				selectedgroupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				selectedgroupFrame.setVisible(true);		// display the frame with components
				selectedgroupFrame.add(selectedgroupPanel);
				
				selectedgroupPanel.setLayout(null);
	
				//joinButton.setBounds(10, 20, 80, 50);
				//selectedgroupPanel.add(joinButton);
				
				leaveButton = new JButton("Public Group");
				leaveButton.setBounds(100, 20, 100, 50);
				selectedgroupPanel.add(leaveButton);
				
				writeButton = new JButton("My Groups");
				writeButton.setBounds(210, 20, 80, 50);
				selectedgroupPanel.add(writeButton);
				
				groupButton = new JButton("Home");
				groupButton.setBounds(400, 20, 80, 50);
				selectedgroupPanel.add(groupButton);
			}
		});
		newgroupButton.setBounds(10, 20, 80, 50);
		groupPanel.add(newgroupButton);
		
		publicgroupButton = new JButton("Public Group");
		publicgroupButton.setBounds(100, 20, 100, 50);
		groupPanel.add(publicgroupButton);
		
		mygroupsButton = new JButton("My Groups");
		mygroupsButton.setBounds(210, 20, 80, 50);
		groupPanel.add(mygroupsButton);
		
		homeButton = new JButton("Home");
		homeButton.setBounds(400, 20, 80, 50);
		groupPanel.add(homeButton);

		
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
