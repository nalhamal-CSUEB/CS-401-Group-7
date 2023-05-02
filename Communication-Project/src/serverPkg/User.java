package serverPkg;

import java.util.ArrayList;

public class User {

	protected String displayName;
	protected UserType userType;
	protected String acctNum;
	protected String username;
	protected String password;
	protected ArrayList<String> groupList;	//Unique groupID should be stored here.
	protected ArrayList<String> chatList;	//Unique chatID should be stored here.
	protected ArrayList<User> blockList;	//Unique userID should be stored here.
	protected boolean status;

    public User(String displayName, String username, String password, UserType userType) {
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.status = true;
    }

    public String getDisplayName() {
        return displayName;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getStatus() {
        return status;
    }

    public ArrayList<User> getBlockList() {
        return blockList;
    }
    
    /****************	Setters	***********************/
    public void setDisplayName(String newName) {
        this.displayName = newName;
    }

    public void setAcctNum(String newAcct) {
        this.acctNum = newAcct;
    }

    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setUserType(UserType type) {
        this.userType = type;   
       }

    public void setStatus(boolean newStatus) {
        this.status = newStatus;
    }

    public void setBlockList(ArrayList<User> blockList) {
      this.blockList = new ArrayList<User>(blockList);
    }
    
    public void setGroupList(String newGroup) {
    	this.groupList= new ArrayList<String>(newGroup);
    }
    
    public void setChatList(String newChat) {
    	this.chatList= new ArrayList<String>(newChat);
    }
    
    /**********************	Mutators	*********************/
    public void addToBlockList(User acctNum) { 
    	blockList.add(acctNum);
    }
    
    public void addToGroupList(String newGroup) {
    	groupList.add(newGroup);
    }
    
    public void addToChatList(String newChat) {
    	chatList.add(newChat);
    }
    
    public void removeFromBlockList(User acctNum) { 
    	blockList.remove(acctNum);
    }
    
    public void removeFromGroupList(String newGroup) {
    	groupList.remove(newGroup);
    }
    
    public void removeFromChatList(String newChat) {
    	chatList.remove(newChat);
    }
    
    public class GeneralUser extends User {
    	  
    	  public GeneralUser(String displayName, String username, String password, UserType userType) {
    		  super(displayName,username, password, userType);    
    		  this.status = true;
    	    }
		/* public void reportIT(String acctNum) {
		        // implementation to report an issue to the IT department
		    }*/

    	}
    /* WIP, First finish General user
    public class ITUser extends User {

    	  public ITUser(String displayName, String username, String password, UserType userType) {
    		  super(displayName,username, password, userType);    
    		  this.status = true;
    	    }
    	
    	public void kick(User user) {
            // implementation to remove user from chat or group
        }
        
        public void log(String username) {
            // implementation to log activity related to a specific user
        }
        
        public void log(Group group) {
            // implementation to log activity related to a specific group
        }
        
        public void log(Chat chat) {
            // implementation to log activity related to a specific chat
        }
        
        public void deleteGroup(Group group) {
            // implementation to delete a group
        }

    }*/
    
}




