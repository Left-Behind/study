package work.azhu.springbootnetty.protocol.response;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;
import work.azhu.springbootnetty.session.Session;
import java.util.List;
import static work.azhu.springbootnetty.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
