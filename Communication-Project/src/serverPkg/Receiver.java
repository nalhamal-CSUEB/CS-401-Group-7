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
		public Chat(String createdBy, String [] userList, Message [] msgList) {
			// TODO Auto-generated constructor stub
			this.createdByUser = createdBy;
			this.userList = userList;
			this.msgList = msgList;
			this.created = new Date();
			
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
		public static int groupCount = 0; 	//used to generate groupID uniqueness.
		
		public Group() {
			// TODO Auto-generated constructor stub
		}

	}

}
