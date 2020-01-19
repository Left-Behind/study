package work.azhu.redisdistributedlock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.UUID;

/**
 * @Author Azhu
 * @Date 2020/1/19 15:58
 * @Description
 */
@Slf4j
public class TestUUID {

    @Test
    public void testUUID1(){
        log.info(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
    }

}
