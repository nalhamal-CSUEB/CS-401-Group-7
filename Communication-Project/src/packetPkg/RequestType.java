package packetPkg;

public enum RequestType {
	SEND_MESSAGE,    //Send Message Request
	RECEIVE_MESSAGE, //Receive Message Request
	CREATE_GROUP,	 //Create Group Request
	CREATE_CHAT,	 //Create Chat Request
	JOIN_GROUP,		 //Join Group Request
	LEAVE_GROUP,	 //Leave Group Request
	KICK_USER,		 //Kick User Request
	REPORT_USER,	 //Report User Request
	BLOCK_USER		 //Block User Request
}
