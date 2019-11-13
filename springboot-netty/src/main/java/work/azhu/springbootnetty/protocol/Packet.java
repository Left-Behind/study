package work.azhu.springbootnetty.protocol;


import lombok.Data;

/**
 * @Author Azhu
 * @Description
 * @Date 2019/11/12 19:57
 **/
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
