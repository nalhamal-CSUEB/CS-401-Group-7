package serverPkg;
import packetPkg.*;
import java.util.ArrayList;

public class ComSystem {
	private ArrayList<User.GeneralUser> generalUser;
	//private ArrayList<ITUser> itUser;
	private ArrayList<User> connectedUser;
	private ArrayList<Receiver.Chat> chats;
	private ArrayList<Receiver.Group> publicGroups;
	private ArrayList<Receiver.Group> privateGroups;
	private ArrayList<Receiver.Group> deletedGroups;
	
	public ComSystem() {
		this.generalUser = new ArrayList<User.GeneralUser>();
		//this.itUser = new ArrayList<ITUser>();
		this.connectedUser = new ArrayList<User>();
		this.chats = new ArrayList<Receiver.Chat>();
		this.publicGroups = new ArrayList<Receiver.Group>();
		this.privateGroups = new ArrayList<Receiver.Group>();
		this.deletedGroups = new ArrayList<Receiver.Group>();
	}
	
	public Packet login(User user) {
		User loadedUser = verify(user);
		if(loadedUser.getUsername().equals("")) {
			Packet packet = new Packet(PacketType.LOGIN, RequestType.NULL , loadedUser);
			packet.setStatusType(StatusType.FAIL);
			return packet;
		}
		Packet packet = new Packet(PacketType.LOGIN, RequestType.NULL , loadedUser);
    	packet.setStatusType(StatusType.SUCCESS);
		return packet;
	}
	
	public User verify(User user) {
		//so far only works with general users
		for (int i = 0; i < generalUser.size(); i++) {
		      if (generalUser[i].getUsername().equals(user.getUsername()) &&
		    	  generalUser[i].getPassword().equals(user.getPassword())) {
		    	  addConnectedUser(user);
		    	  return generalUser[i];
		      }
		}
		User failedUser = new User("","","","");
		return failedUser;
	}
	
	public boolean logout(User user) {
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
	public void addGeneralUser(User.GeneralUser user) {
		generalUser.add(user);
	}
	
	public void removeGeneralUser(User user) {
		//no delete account
	}
	
	public ArrayList<User.GeneralUser> getGeneralUsers() {
		return generalUser;
	}
	
	//it user methods
	/*public void addITUser(User user) {
		itUser.add(user);
	}*/
	
	public void removeITUser(User user) {
		//no delete account
	}
	/*
	public ArrayList<User> getITUsers() {
		return itUser;
	}*/
	
	//group methods
	public void addGroup(Receiver.Group group) {
		if (group.isPrivate == true) {
			privateGroups.add(group);
		}
		else {
			publicGroups.add(group);
		}
	}
	
	public void removeGroup(Receiver.Group group) {
		//checks for private or public then copies group to deleted groups while
		//removing from visible groups
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
			    	  publicGroups.remove(i);
			      }
			}
		}
	}
	
	public ArrayList<Receiver.Group> getPublicGroups() {
		return publicGroups;
	}
	
	public ArrayList<Receiver.Group> getPrivateGroups() {
		return privateGroups;
	}
	
	public ArrayList<Receiver.Group> getDeletedGroups() {
		return deletedGroups;
	}
	
	public void writeToGroup(Receiver.Group group, Message message) {
		group.addMessage(message);
	}
	
	public Packet readGroup(Receiver.Group group) {
		Packet packet = new Packet(PacketType.REQUEST, RequestType.RECEIVE_MESSAGE_GROUP, group);
		return packet;
	}
	
	//send invite groups
	public Packet sendInvite(User user, Receiver.Group group) {
		Packet packet = new Packet(PacketType.REQUEST, RequestType.RECEIVE_INVITE, user, group);
		return packet;		
	}
	
	public void addUserToGroup(String user, Receiver.Group group) {
		group.addUser(user);
	}
	
	//chat methods
	public void addChat(Receiver.Chat chat) {
		chats.add(chat);
	}
	
	public void writeToChat(Receiver.Chat chat, Message message) {
		for (i = 0; i < chats.size(); i++) {
			if (chats[i].getChatID().equals(chat.getChatID())) {
				chat.addMessage(message);
			}
			else { //first message
				Receiver.Chat newChat = new Receiver.Chat(ArrayList<User> userList); // needs work
				addChat(newChat);
			}
		}
	}
	
	public Packet readChat(Receiver.Chat chat) {
		Packet packet = new Packet(PacketType.REQUEST, RequestType.RECEIVE_MESSAGE_CHAT, chat);
		return packet;
	}
	
	//Add to block list
	public Packet addBlockList(User user, User blocked) {
		user.addToBlockList(blocked);
		packet = new Packet("REQUEST", "BLOCKED", user);
	}
	
}
