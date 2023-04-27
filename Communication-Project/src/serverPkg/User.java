package serverPkg;

public class User {

	protected String displayName;
	protected UserType userType;
	protected String acctNum;
	protected String username;
	protected String password;
	protected String[] blockList;
	protected boolean status;

    public User(String displayName, String username, String password, UserType userType) {
        this.displayName = displayName;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.status = true;
    }

    public Group createGroup(User admin, boolean isPrivate, String groupName) {
        // implementation to create a new Group object
    }

    public void writeMessage(Message message, String fromAcctNum, String destinationID) {
        // implementation to write a new message
    }

    public void readMessage(Message message) {
        // implementation to read a message
    }

    public String addToBlockList(String acctNum) {
    	 return "";
        // implementation to add a user to the block list
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

    public String[] getBlockList() {
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

    }
    
}




