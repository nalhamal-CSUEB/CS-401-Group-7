package packetPkg;
import serverPkg.Message;
public class Packet {
	
	protected PacketType type;
	protected RequestType request;
	protected Message message;
	protected String status = "";
	
	public Packet(PacketType type, RequestType request, Message message) {
		this.type = type;
		this.request = request;
		this.message = message;
	}
	
	public PacketType getPacketType() {
		return type;
	}
	
	public RequestType getRequestType() {
		return request;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
