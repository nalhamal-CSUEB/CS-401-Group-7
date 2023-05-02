package serverPkg;

import java.util.ArrayList;

public class User {

	protected String displayName;
	protected UserType userType;
	protected String acctNum;
	protected String username;
	protected String password;
	protected ArrayList<User> blockList;
	protected boolean status;

    public User(String displayName, String username, String password, UserType userType) {
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.status = true;
    }

    public void addToBlockList(User acctNum) { 
    	blockList.add(acctNum);
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
    
    public class GeneralUser extends User {
    	  
    	  public GeneralUser(String displayName, String username, String password, UserType userType) {
    		  super(displayName,username, password, userType);    
    		  this.status = true;
    	    }
		 public void reportIT(String acctNum) {
		        // implementation to report an issue to the IT department
		    }

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




