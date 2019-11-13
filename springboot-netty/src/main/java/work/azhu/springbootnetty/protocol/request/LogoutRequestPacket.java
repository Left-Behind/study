package work.azhu.springbootnetty.protocol.request;

import lombok.Data;
import work.azhu.springbootnetty.protocol.Packet;
import static work.azhu.springbootnetty.protocol.command.Command.LOGOUT_REQUEST;

@Data
public class LogoutRequestPacket extends Packet {
    @Override
    public Byte getCommand() {

        return LOGOUT_REQUEST;
    }
}
