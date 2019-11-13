package work.azhu.springbootnetty.protocol.request;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;

import static work.azhu.springbootnetty.protocol.command.Command.LIST_GROUP_MEMBERS_REQUEST;

@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_REQUEST;
    }
}
