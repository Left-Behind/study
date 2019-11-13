package work.azhu.springbootnetty.protocol.response;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;
import static work.azhu.springbootnetty.protocol.command.Command.MESSAGE_RESPONSE;

@Data
public class MessageResponsePacket extends Packet {

    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {

        return MESSAGE_RESPONSE;
    }
}
