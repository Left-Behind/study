package work.azhu.springbootnetty.protocol.request;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;

import static work.azhu.springbootnetty.protocol.command.Command.QUIT_GROUP_REQUEST;

@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
