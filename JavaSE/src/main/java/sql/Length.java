package main.java.sql;

import org.junit.Test;

/**
 * @author Azhu
 * @date 2019/8/22 17:42
 */
public class Length {


    @Test
    public void Length(){
        String s="中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中中";

        String ss="中";
        String sss="";
        for(int i=0;i<50;i++){
            sss=sss+ss;
        }
        System.out.println(sss);
        System.out.println(s.length());
    }
}
