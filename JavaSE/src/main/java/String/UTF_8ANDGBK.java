package String;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class UTF_8ANDGBK {

    @Test
    public void T() throws UnsupportedEncodingException {
        String s1="系统已存在该订单号";
        String gbk = new String(s1.getBytes("UTF-8"), "gbk");

        System.out.println(gbk);//绯荤粺宸插瓨鍦ㄨ璁㈠崟鍙
        String utf8 = new String(gbk.getBytes("gbk"), "utf-8");

        System.out.println(utf8);//系统已存在该订单号
    }
}
