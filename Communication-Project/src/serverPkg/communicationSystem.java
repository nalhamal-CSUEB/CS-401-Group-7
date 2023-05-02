package serverPkg;

import java.util.ArrayList;

public class communicationSystem {
	private ArrayList<GeneralUser> generalUser;
	private ArrayList<ITUser> itUser;
	private ArrayList<User> connectedUser;
	private ArrayList<Chat> chats;
	private ArrayList<Group> publicGroups;
	private ArrayList<Group> privateGroups;
	private ArrayList<Group> deletedGroups;
	
	public communicationSystem() {
		this.generalUser = new ArrayList<GeneralUser>();
		this.itUser = new ArrayList<ITUser>();
		this.connectedUser = new ArrayList<User>();
		this.chats = new ArrayList<Chat>();
		this.publicGroups = new ArrayList<Group>();
		this.privateGroups = new ArrayList<Group>();
		this.deletedGroups = new ArrayList<Group>();
	}
	
	public bool login(User user) {
		if(verify(user) == true) {
			return true;
		}
		return false;
	}
	
	public bool verify(User user) {
		//so far only works with general users
		for (int i = 0; i < connectedUser.size(); i++) {
		      if (generalUser.getUsername().equals(user.getUsername()) &&
		    	  generalUser.getPassword().equals(user.getPassword())) {
		    	  addConnectedUser(user);
		    	  return true;
		      }
		}
		return false;
	}
	
	public bool logout(User user) {
		for (int i = 0; i < connectedUser.size(); i++) {
		      if (connectedUser.getAcctNum().equals(user.getAcctNum())) {
		    	  connectedUser.remove(i);
		      }
		}
		return true;
	}
	
	//connected user methods
	public void addConnectedUser(User user) {
		connectedUser.add(user);
	}
	
	public void removeConnectedUser(User user) {
		for (int i = 0; i < connectedUser.size(); i++) {
		      if (connectedUser.getAcctNum().equals(user.getAcctNum())) {
		    	  connectedUser.remove(i);
		      }
		}
	}
	
	public ArrayList<User> getConnectedUsers() {
		return connectedUser;
	}
	
	//general user methods
	public void addGeneralUser(GeneralUser user) {
		generalUser.add(user);
	}
	
	public void removeGeneralUser(User user) {
		//no delete account
	}
	
	public ArrayList<User> getGeneralUsers() {
		return generalUser;
	}
	
	//it user methods
	public void addITUser(User user) {
		itUser.add(user);
	}
	
	public void removeITUser(User user) {
		//no delete account
	}
	
	public ArrayList<User> getITUsers() {
		return itUser;
	}
	
	//group methods
	public void addGroup(Group group) {
		if (group.isPrivate == true) {
			privateGroups.add(group);
		}
		else {
			publicGroups.add(group);
		}
	}
	
	public void removeGroup(Group group) {
		//checks for private or public then copies group to deleted groups while
		//removing from visable groups
		if (group.isPrivate == true) {
			for (int i = 0; i < privateGroups.size(); i++) {
			      if (privateGroups.getGroupID().equals(group.getGroupID())) {
			    	  deletedGroups.add(privateGroups[i]);
			    	  privateGroups.remvoe(i);
			      }
			}
		}
		else {
			for (int i = 0; i < publicGroups.size(); i++) {
			      if (publicGroups.getGroupID().equals(group.getGroupID())) {
			    	  deletedGroups.add(publicGroups[i]);
			    	  publicGroups.remvoe(i);
			      }
			}
		}
	}
	
	public ArrayList<Group> getPublicGroups() {
		return publicGroups;
	}
	
	public ArrayList<Group> getPrivateGroups() {
		return privateGroups;
	}
	
	public ArrayList<Group> getDeletedGroups() {
		return deletedGroups;
	}
	
	public void writeToGroup(Group group, Message message) {
		group.addMessage(message);
	}
	
	public Packet readGroup(Group group) {
		packet = new Packet("REQUEST", "RECEIVE_MESSAGE", group);
		return packet;
	}
	
	//send invite groups
	public Packet sendInvite(User user, Group group) {
		packet = new Packet("REQUEST", "RECIEVE_INVITE", user, group);
		return packet;		
	}
	
	public void addUserToGroup(User user, Group group) {
		group.addUser(user);
	}
	
	//chat methods
	public void addChat(Chat chat) {
		chats.add(chat);
	}
	
	public void writeToChat(Chat chat, Message message) {
		for (i = 0; i < chats.size(); i++) {
			if (chats[i].getChatID().equals(chat.getChatID())) {
				chat.addMessage(message);
			}
			else { //first message
				Chat newChat = new Chat(ArrayList<User> userList); // needs work
				addChat(newChat);
			}
		}
	}
	
	public Packet readChat(Chat chat) {
		packet = new Packet("REQUEST", "RECEIVE_MESSAGE", chat);
		return packet;
	}
	
	//Add to block list
	public Packet addBlockList(User user, User blocked) {
		user.addToBlockList(blocked);
		packet = new Packet("REQUEST", "BLOCKED", user);
	}
	
}
