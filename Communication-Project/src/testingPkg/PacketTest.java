package testing;

import serverPkg.Message;
import serverPkg.MsgType;
import org.junit.Test;
import org.junit.Assert;

public class PacketTest {

    @Test
    public void testGetPacketType() {
        Message message = new Message("12345", "67890", "Hello World!", MsgType.TEXT);
        Packet packet = new Packet(PacketType.MESSAGE, RequestType.SEND, message);
        Assert.assertEquals(PacketType.MESSAGE, packet.getPacketType());
    }

    @Test
    public void testGetRequestType() {
        Message message = new Message("12345", "67890", "Hello World!", MsgType.TEXT);
        Packet packet = new Packet(PacketType.MESSAGE, RequestType.SEND, message);
        Assert.assertEquals(RequestType.SEND, packet.getRequestType());
    }

    @Test
    public void testGetMessage() {
        Message message = new Message("12345", "67890", "Hello World!", MsgType.TEXT);
        Packet packet = new Packet(PacketType.MESSAGE, RequestType.SEND, message);
        Assert.assertEquals(message, packet.getMessage());
    }

    @Test
    public void testGetStatus() {
        Message message = new Message("12345", "67890", "Hello World!", MsgType.TEXT);
        Packet packet = new Packet(PacketType.MESSAGE, RequestType.SEND, message);
        Assert.assertEquals("", packet.getStatus());
    }

    @Test
    public void testSetStatus() {
        Message message = new Message("12345", "67890", "Hello World!", MsgType.TEXT);
        Packet packet = new Packet(PacketType.MESSAGE, RequestType.SEND, message);
        packet.setStatus("SUCCESS");
        Assert.assertEquals("SUCCESS", packet.getStatus());
    }
}