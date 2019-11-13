package work.azhu.springbootnetty.protocol.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.azhu.springbootnetty.protocol.Packet;
import static work.azhu.springbootnetty.protocol.command.Command.GROUP_MESSAGE_REQUEST;

@Data
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {
    private String toGroupId;
    private String message;

    public GroupMessageRequestPacket(String toGroupId, String message) {
        this.toGroupId = toGroupId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return GROUP_MESSAGE_REQUEST;
    }
}
