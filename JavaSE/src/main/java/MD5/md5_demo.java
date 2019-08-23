package main.java.MD5;

import org.junit.Test;

/**
 * @author Azhu
 * @date 2019/8/23 10:30
 */
public class md5_demo {


    @Test
    public void Test1() throws Exception {
        String pwd="ren123456";
        String pwd1="C80D171B81624145618791D99107554A";
        String pwd2="C80D171B81624145618791D99107554A";
        System.out.println(pwd1.equals(pwd2));
        System.out.println(MD5.code(pwd1));
    }
}
