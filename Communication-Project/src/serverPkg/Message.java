package serverPkg;

import java.util.Date;


public class Message {
	protected String fromAcctNum;
    protected String destinationID;
    protected String message;
    protected Date date;
    protected MsgType msgType;

    //Default Constructor
    public Message() {
    	this(null, null, null, null);
    	this.date = null;
    }
    
    // constructor
    public Message(String fromAcctNum, String destinationID, String message, MsgType msgType){
        this.fromAcctNum = fromAcctNum;
        this.destinationID = destinationID;
        this.date = new Date();
        this.msgType = msgType;
        this.message = message;
    }
	
	// getters
    public String getFrom(){
    	return fromAcctNum;
    }

    public String getTo(){
    	return destinationID;
    }

    public MsgType getMsgType(){
    	return msgType;
    }
    
    public String getMessage() {
    	return message;
    }

    public Date getDate() {
    	return date;
    }
}