package timeformat;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void test11(){
        Object object=null;
        System.out.println((Long)object);
        Map<String,Object> map= new HashMap<>();
        System.out.println(map.get("originalFilename"));
    }
}
