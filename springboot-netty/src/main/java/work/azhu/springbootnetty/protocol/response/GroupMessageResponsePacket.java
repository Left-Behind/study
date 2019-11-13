package work.azhu.springbootnetty.protocol.response;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;
import work.azhu.springbootnetty.session.Session;
import static work.azhu.springbootnetty.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }
}
