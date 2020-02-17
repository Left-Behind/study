package work.azhu.common.test_package;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import work.azhu.common.test_dependent_package.Parent;
import work.azhu.common.test_dependent_package.Son;
import work.azhu.common.util.SerializeUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SerializeTest {

    @Test
    public void test1(){

        Son son = new Son(1,2,3);
        List<Son> sonList = new ArrayList<>();
        sonList.add(new Son(1,2,3));
        sonList.add(new Son(2,3,4));
        sonList.add(new Son(3,4,5));
        Parent parent = new Parent(1,2,3,son,sonList);

        byte[] sonS = SerializeUtils.serialize(son);
        log.info("son序列化之后的 byte: "+sonS);

        Son unSson = (Son) SerializeUtils.unserialize(sonS);
        log.info("sonS反序列化之后的实列 "+unSson);
        byte[] sonP = SerializeUtils.serialize(parent);
        log.info("parent序列化之后的 byte: "+sonP);

        Parent unSparent = (Parent) SerializeUtils.unserialize(sonP);
        log.info("sonP反序列化之后的实列 "+unSparent);
    }

    @Test
    public void testRedis(){
        //1.设置ip地址和端口
        Jedis jedis=new Jedis("localhost",6379);
        Son son = new Son(1,2,3);
        List<Son> sonList = new ArrayList<>();
        sonList.add(new Son(1,2,3));
        sonList.add(new Son(2,3,4));
        sonList.add(new Son(3,4,5));
        Parent parent = new Parent(1,2,3,son,sonList);

        byte[] sonS = SerializeUtils.serialize(son);
        log.info("son序列化之后的 byte: "+sonS);
        jedis.set("1".getBytes(),sonS);
        Son unSson = (Son) SerializeUtils.unserialize(jedis.get("1".getBytes()));
        log.info("sonS反序列化之后的实列 "+unSson);
        byte[] sonP = SerializeUtils.serialize(parent);
        log.info("parent序列化之后的 byte: "+sonP);

        jedis.set("2".getBytes(),sonP);
        Parent unSparent = (Parent) SerializeUtils.unserialize(jedis.get("2".getBytes()));
        log.info("sonP反序列化之后的实列 "+unSparent);
        jedis.close();
    }


}
