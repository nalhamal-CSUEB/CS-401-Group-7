package packetPkg;
import serverPkg.Message;
public class Packet {
	
	protected PacketType type;
	protected RequestType request;
	protected Message message;
	
	public Packet(PacketType type, RequestType request, Message message) {
		this.type = type;
		this.request = request;
		this.message = message;
	}
	
	PacketType getPacketType() {
		return type;
	}
	
	RequestType getRequestType() {
		return request;
	}
	
	Message getMessage() {
		return message;
	}
}
