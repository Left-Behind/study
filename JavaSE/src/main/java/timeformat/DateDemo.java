package timeformat;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Azhu
 * @date 2019/8/28 10:37
 */
public class DateDemo {

    @Test
    public void getToday(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("d");
        Integer today=Integer.valueOf(dateFormat.format(new Date()));
        System.out.println(today);
    }
    @Test
    public void getMonth(){

        SimpleDateFormat dateFormat = new SimpleDateFormat("M");
        Integer today=Integer.valueOf(dateFormat.format(new Date()));
        System.out.println(today);
    }
}
