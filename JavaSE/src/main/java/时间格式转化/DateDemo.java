package main.java.时间格式转化;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Azhu
 * @date 2019/8/28 10:37
 */
public class DateDemo {

    @Test
    public void SimpleDateFormatDemo(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("d");
        Integer today=Integer.valueOf(dateFormat.format(new Date()));
        System.out.println(today);
    }
}
