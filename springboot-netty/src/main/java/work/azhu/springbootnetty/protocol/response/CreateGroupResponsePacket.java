package work.azhu.springbootnetty.protocol.response;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;

import java.util.List;

import static work.azhu.springbootnetty.protocol.command.Command.CREATE_GROUP_RESPONSE;

@Data
public class CreateGroupResponsePacket extends Packet {
    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_RESPONSE;
    }
}
