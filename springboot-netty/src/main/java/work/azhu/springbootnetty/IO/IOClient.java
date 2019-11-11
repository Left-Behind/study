package work.azhu.springbootnetty.IO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2019/11/11 20:40
 **/
public class IOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8002);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world----->NettyServer").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();
    }
}
