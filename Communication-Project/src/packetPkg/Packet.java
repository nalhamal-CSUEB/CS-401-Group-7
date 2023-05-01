package packetPkg;

import serverPkg.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Packet implements Serializable{
	private static final long serialVersionUID = 1L;	//Warning was given by IDE. This line was added to satisfy the warning condition.
	protected PacketType type;
	protected RequestType request;
	protected StatusType status;
	protected Message message;
	protected ArrayList<Message> msgList;
	protected Receiver location;
	protected Receiver.Group group;
	protected Receiver.Chat chat;
	protected ArrayList<Receiver> receiverList;
	protected User userID;
	protected User.GeneralUser genUserID;
	protected User.ITUser ITUserID;
	protected ArrayList<User> userList;
	protected String string;
	
	//Default Constructor
	public Packet(){
		this(null, null, null, null, null,
				null, null, null, null,
				null, null);
	}	
	
	//Login Constructor
	public Packet(User newUser, String password){
		this.setPacketType(PacketType.LOGIN);
		this.setUser(newUser);
		this.setString(password);
	}
	
	//Logout Constructor
	public Packet(User oldUser) {
		this.setPacketType(PacketType.LOGOUT);
		this.setUser(oldUser);		
	}
	
	//SEND_MESSAGE Constructor
	public Packet(PacketType packet, User fromUser, Receiver location, Message newMessage) {
		this.setRequestType(RequestType.SEND_MESSAGE);
		this.setReceiver(location);
		this.setMessage(newMessage);
	}
	
	//RECEIVE_MESSAGE Constructor
	public Packet(Receiver location) {
		this.setRequestType(RequestType.RECEIVE_MESSAGE);
		this.setReceiver(location);
	}
	
	//CREATE_GROUP Constructor
	public Packet(Receiver.Group newGroup) {
		this.setRequestType(RequestType.CREATE_GROUP);
		this.setGroup(newGroup);
	}
	
	//CREATE_CHAT Constructor
	public Packet(Receiver.Chat newChat) {
		this.setRequestType(RequestType.CREATE_CHAT);
		this.setChat(newChat);
	}
	
	//JOIN_GROUP Constructor
	public Packet(Receiver.Group newGroup, User newUser) {
		this.setRequestType(RequestType.JOIN_GROUP);
		this.setGroup(newGroup);
		this.setUser(newUser);
	}
	
	//LEAVE_GROUP Constructor
	public Packet(Receiver.Group newGroup, User newUser) {
		this.setRequestType(RequestType.JOIN_GROUP);
		this.setGroup(newGroup);
		this.setUser(newUser);
	}
	
	//KICK_USER Constructor
	
	//REPORT_USER Constructor
	
	//BLOCK_USER Constructor
	
	
	public Packet(PacketType newType, RequestType newRequest, StatusType newStatus, Message newMessage,
			ArrayList<Message> newMsgList, Receiver.Group newGroup, Receiver.Chat newChat, ArrayList<Receiver> newReceiverList,
			User newUser, ArrayList<User> newUserList, String newString) {
		this.setPacketType(type);
		this.setRequestType(request);
		this.setStatusType(status);
		this.setMessage(message);
	}
	/*****************Begin	Getters ***************************************/
	public PacketType getPacketType() {
		return type;
	}
	
	public RequestType getRequestType() {
		return request;
	}
	
	public StatusType getStatusType() {
		return status;
	}
	public Message getMessage() {
		return message;
	}
	
	public ArrayList<Message> getMsgList(){
		return msgList;
	}
	
	public Receiver getLocation(){
		return location;
	}
	
	public Receiver.Group getGroup(){
		return group;
	}
	
	public Receiver.Chat getChat(){
		return chat;
	}
	
	public ArrayList<Receiver> getReceiverList(){
		return receiverList;
	}
	
	public User getUser(){
		return userID;
	}
	public User getGenUser(){
		return genUserID;
	}
	public User getITUser(){
		return ITUserID;
	}

	public ArrayList<User> getUserList(){
		return userList;
	}
	
	public String getString(){
		return string;
	}
	/*****************End	Getters ***************************************/
	/*****************Begin	Setters ***************************************/
	public void setPacketType(PacketType type) {
		this.type = type;
	}
	
	public void setRequestType(RequestType request) {
		this.request = request;
	}
	
	public void setStatusType(StatusType status) {
		this.status = status;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	public void setMsgList(ArrayList<Message> newList){
		this.msgList = new ArrayList<Message>(newList);
	}
	
	public void setReceiver(Receiver newLocation){
		this.location = newLocation;
	}
	
	public void setGroup(Receiver.Group newGroup){
		this.group = newGroup;
	}
	
	public void setChat(Receiver.Chat newChat){
		this.chat = newChat;
	}
	
	public void setReceiverList(ArrayList<Receiver> newList){
		this.receiverList = new ArrayList<Receiver>(newList);
	}
	
	public void setUser(User newUser){
		this.userID = newUser;
	}
	
	public void setITUser(User.ITUser newUser){
		this.ITUserID = newUser;
	}

	public void setUserList(User.GeneralUser newUser){
		this.genUserID = newUser;
	}
	
	public void setString(String newString){
		this.string = newString;
	}
	/*****************End Setters ***************************************/
	
	
	
}
