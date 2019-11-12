package work.azhu.springbootnetty;

import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;
import work.azhu.springbootnetty.protocol.PacketCodeC;
import work.azhu.springbootnetty.protocol.command.LoginRequestPacket;
import work.azhu.springbootnetty.protocol.command.Packet;
import work.azhu.springbootnetty.serialize.Serializer;
import work.azhu.springbootnetty.serialize.impl.JSONSerializer;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/11/12 20:26
 **/
public class PackCodeCTest {
    @Test
    public void encode() {

        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId(123);
        loginRequestPacket.setUsername("zhangsan");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = new PacketCodeC();
        ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));

    }
}
