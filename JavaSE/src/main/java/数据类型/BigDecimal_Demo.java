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
        BigDecimal minPrice=new BigDecimal(1000);
        BigDecimal maxPrice=new BigDecimal(50000);
        BigDecimal amount=new BigDecimal(999);

        for(int i=0;i<50010;i++){
            amount=new BigDecimal(i);
            if(minPrice.compareTo(amount)>0||maxPrice.compareTo(amount)<0){
                System.out.println(amount+"dsfsdf");
                System.out.println("s");
            }
        }

    }
}
