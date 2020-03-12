package work.azhu.springbootrocketmq.rocketmq.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import work.azhu.springbootrocketmq.model.Message;
import work.azhu.springbootrocketmq.rocketmq.Constant;


@Component
@Slf4j
public class RocketMqProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;


    public void sendOneWay(Message message){
        rocketMQTemplate.sendOneWay(Constant.TOPIC_SENDONEWAY, message);
    }

    public void syncSend(Message message){
        rocketMQTemplate.syncSend(Constant.TOPIC_SYNCSEND, message);
    }

    public void asyncSend(Message message){
        rocketMQTemplate.asyncSend(Constant.TOPIC_ASYNCSEND, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("发送消息成功！");
            }

            @Override
            public void onException(Throwable throwable) {
                log.error("发送消息失败");
                log.error(throwable.getMessage());
            }
        });
    }


}
