package serverPkg;

import java.io.Serializable;
import java.util.Date;


public class Message implements Serializable {
	protected String fromAcctNum;
    protected String destinationID;
    protected String message;
    protected Date date;
    protected MsgType msgType;

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