package serverPkg;

import java.util.Date;

//Implemented by Nabil Alhamal
public class Receiver {
	//Fields for the Receiver Class
	protected String userList [];	//Holds the list of users
	protected Message msgList [];	//Holds the list of message objects
	protected Date created;		//Date the Receiver was created
	protected String createdByUser; //Name of user who created the Receiver
	
	public Message [] getMsgList() {
		return msgList;
	}
	
	public Message getMessage(int index) {
		return msgList[index];
	}
	
	public String [] getUserList() {
		return userList;
	}
	
	public String getUserID(int index) {
		return userList[index];
	}
	
	public String getCreator() {
		return createdByUser;
	}
	
	public String getDate() {
		return created.toString();
	}
	
	public void addMessage(Message newMessage) {
		//Needs implementation to add to the end of the list. May want to change this to a sorted list
	}
	
	//##############	Child Class - Chat	#######################################
	public class Chat extends Receiver {
		//Fields for the Chat Class - Child of Receiver
		private String chatID;
		private String chatName;
		public static int chatCount = 0; //used to generate chatID uniqueness.
		
		//Constructor
		public Chat(String user, String [] userList, Message [] msgList) {
			this.createdByUser = user;
			this.userList = userList;
			this.msgList = msgList;
			this.created = new Date();
			chatID = idHelper(chatCount, "Cht-");
			chatCount++;
			
		}
		
		public String getChatID() {
			return chatID;
		}
		
		public String getChatName() {
			return chatName;
		}
		
		public void setChatName(String newChatName) {
			chatName = newChatName;
		}

	}

	//##############	Child Class - Group	#######################################
	public class Group extends Receiver{
		//Fields for the Group Class - Child of Receiver
		private String leadMod;			//Current lead moderator of a group - Default is the creator of the group
		private String moderators[];	//Additional moderators added by the lead moderator
		private String groupID;			//Uniquely Generated groupID
		private String groupName;		//Name for the Group. Doesn't have to be unique at the moment. Can implement uniqueness later if needed.
		public boolean isPrivate;		//Indicates whether the group is designated private or public. If private, should not be accessible by users not on the userList.
		public boolean deleted;			//Indicates whether the group is deleted. If it is, the object will remain for log purposes, but can't be accessed by General Users.
		public static int groupCount = 0; 	//used to generate groupID uniqueness.
		
		//Group Constructor
		public Group(String user, boolean privacy, String newGroupName) {
			leadMod = user;
			createdByUser = user;
			//addUser to the list. Need to implement.
			isPrivate = privacy;
			deleted = false;
			groupName = newGroupName;
			created = new Date();
			groupID = idHelper(groupCount, "Grp-");
			groupCount++;
		}

		public String getGroupID() {
			return groupID;
		}
		
		public String getLeadModerator() {
			return leadMod;
		}
		
		public String [] getModerators() {
			return moderators;
		}
		
		public String getGroupname() {
			return groupName;
		}
		
		public boolean getDeletedStatus() {
			return deleted;
		}
		
		
	}
	
	//Adds a user to the list
	
	//Removes a user from the list
	
	//Adds a moderator to the list
	
	//Removes a moderator from the list
	
	//Generates IDs for groups and chats.
	private String idHelper(int counter, String receiver ) {
		String temp = new String();
		temp = ("00000000" + Integer.toString(counter)).substring(Integer.toString(counter).length()); //Converts counter to a string, and adds leading zeroes.
		return receiver + temp;
	}

}
