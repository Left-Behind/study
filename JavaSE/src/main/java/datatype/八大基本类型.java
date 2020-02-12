package datatype;

import lombok.ToString;
import org.junit.Test;

public class 八大基本类型 {

    @Test
    public void show(){
        boolean b; Boolean   B; // 1bit
        byte   bt; Byte     BT; // 1字节
        char    c; Character C; // 2字节
        short   s; Short     S; // 2字节
        int     i; Integer   I; // 4字节
        float   f; Float     F; // 4字节
        long    l; Long      L; // 8字节
        double  d; Double    D; // 8字节

        System.out.println("Byte.MIN_VALUE = "+Byte.MIN_VALUE+"  Byte.MAX_VALUE = "+Byte.MAX_VALUE);
        System.out.println("Character.MIN_VALUE = "+Character.MIN_VALUE+"  Character.MAX_VALUE = "+Character.MAX_VALUE);
        System.out.println("Short.MIN_VALUE = "+Short.MIN_VALUE+"  Short.MAX_VALUE = "+Short.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = "+Integer.MIN_VALUE+"  Integer.MAX_VALUE = "+Integer.MAX_VALUE);
        System.out.println("Float.MIN_VALUE = "+Float.MIN_VALUE+"  Float.MAX_VALUE = "+Float.MAX_VALUE);
        System.out.println("Long.MIN_VALUE = "+Long.MIN_VALUE+"  Long.MAX_VALUE = "+Long.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = "+Double.MIN_VALUE+"  Double.MAX_VALUE = "+Double.MAX_VALUE);
    }
}
