package work.azhu.springbootnetty.protocol.command;

import lombok.Data;
import work.azhu.springbootnetty.protocol.command.Packet;

import static work.azhu.springbootnetty.protocol.command.Command.LOGIN_REQUEST;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/11/12 20:00
 **/
@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {

        return LOGIN_REQUEST;
    }
}
