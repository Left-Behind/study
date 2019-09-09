package main.java.String;

import org.junit.Test;

public class StringDemo {

    @Test
    public void Test1() {

        String s1 = "123";
        String s2 = new String("123");
        String s3 = new String("123");
        String s4="123";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1==s4);
    }

    @Test
    public void Test2() {
        int a = 10 >> 1;
        int b = a++;
        int c = ++a;
        int d = b * a++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }
}
