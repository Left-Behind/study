package work.azhu.springbootrocketmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import work.azhu.springbootrocketmq.model.Message;
import work.azhu.springbootrocketmq.rocketmq.producer.RocketMqProducer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRocketmqApplicationTests {

    @Autowired
    private RocketMqProducer rocketMqProducer;

    @Test
    public void rocketMqSendOneWay(){
        for (int i = 0; i < 10; i++){
            Message message = new Message(i+1000L,"SendOneWay1");
            rocketMqProducer.sendOneWay(message);
        }
    }

    @Test
    public void rocketMqSyncSend(){
        for (int i = 0; i < 10; i++){
            Message message = new Message(i+1000L,"SyncSend1");
            rocketMqProducer.syncSend(message);
        }
    }

    @Test
    public void rocketMqAsyncSend(){
        for (int i = 0; i < 10; i++){
            Message message = new Message(i+1000L,"AsyncSend1");
            rocketMqProducer.asyncSend(message);
        }
    }

}
