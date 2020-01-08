package datatype;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Author Azhu
 * @Description //TODO
 * @Date 2020/1/7 22:40
 **/
public class char_demo {
    @Test
    public void char_length() throws UnsupportedEncodingException {
        String str = "中";
        char x = '中';
        byte[] bytes = null;
        byte[] bytes_utf_8 = null;
        byte[] bytes_gbk = null;
        try {
            bytes = charToByte(x);
            bytes_utf_8 = str.getBytes("utf-8");
            bytes_gbk = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("bytes 大小：" + bytes.length);
        System.out.println("bytes_utf_8大小：" + bytes_utf_8.length);
        System.out.println("bytes_gbk大小：" + bytes_gbk.length);
    }

    public static byte[] charToByte(char c) {
        byte[] b = new byte[2];
        b[0] = (byte) ((c & 0xFF00) >> 8);
        b[1] = (byte) (c & 0xFF);
        return b;

    }
}
