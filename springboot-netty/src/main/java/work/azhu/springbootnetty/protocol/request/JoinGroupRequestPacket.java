package work.azhu.springbootnetty.protocol.request;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;

import static work.azhu.springbootnetty.protocol.command.Command.JOIN_GROUP_REQUEST;


@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return JOIN_GROUP_REQUEST;
    }
}
