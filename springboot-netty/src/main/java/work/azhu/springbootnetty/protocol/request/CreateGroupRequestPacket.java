package work.azhu.springbootnetty.protocol.request;

import lombok.Data;

import work.azhu.springbootnetty.protocol.Packet;

import java.util.List;

import static work.azhu.springbootnetty.protocol.command.Command.CREATE_GROUP_REQUEST;


@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;

    @Override
    public Byte getCommand() {

        return CREATE_GROUP_REQUEST;
    }
}
