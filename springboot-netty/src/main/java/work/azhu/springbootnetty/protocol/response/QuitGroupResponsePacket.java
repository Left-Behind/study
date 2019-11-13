package work.azhu.springbootnetty.protocol.response;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;

import static work.azhu.springbootnetty.protocol.command.Command.QUIT_GROUP_RESPONSE;

@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_RESPONSE;
    }
}
