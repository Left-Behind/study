package main.java.数据类型;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Azhu
 * @date 2019/8/21 14:31
 */
public class BigDecimal_Demo {

    @Test
    public void compareTo(){
        BigDecimal a = new BigDecimal("1.00");
        BigDecimal b = new BigDecimal(1.00);

        System.out.println(a.compareTo(b));
    }
}
