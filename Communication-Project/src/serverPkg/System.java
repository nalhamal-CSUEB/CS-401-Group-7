package serverPkg;
import java.util.ArrayList;
public class System {
	private ArrayList<GeneralUser> generalUser;
	private ArrayList<ITUser> itUser;
	private ArrayList<User> connectedUser;
	private ArrayList<Chat> chats;
	private ArrayList<Group> publicGroups;
	private ArrayList<Group> privateGroups;
	private ArrayList<Group> deletedGroups;
	
	public System() {
		this.generalUser = new ArrayList<GeneralUser>();
		this.itUser = new ArrayList<ITUser>();
		this.connectedUser = new ArrayList<User>();
		this.chats = new ArrayList<Chat>();
		this.publicGroups = new ArrayList<Group>();
		this.privateGroups = new ArrayList<Group>();
		this.deletedGroups = new ArrayList<Group>();
	}
	
	public bool login(User user) {
		return true;
	}
	
	public bool verify(User user) {
		return true;
	}
	
	public bool logout() {
		return true;
	}
	
	//connected user methods
	public void addConnectedUser(User user) {
		connectedUser.add(user);
	}
	
	public void removeConnectedUser(User user) {
		for (int i = 0; i < connectedUser.size(); i++) {
		      if (connectedUser.password.equals(user.password)) {
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
	
	public void writeToGroup() {
		
	}
	
	public Packet readChat() {
		
	}
	
	//chat methods
	public void addChat(Chat chat) {
		chats.add(chat);
	}
	
	public void writeToChat() {
		
	}
	
	public Packet readChat() {
		
	}
}
