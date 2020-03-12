package work.azhu.springbootrocketmq.rocketmq.consumer;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Service;
import work.azhu.springbootrocketmq.rocketmq.Constant;

import java.io.UnsupportedEncodingException;

@Service

@RocketMQMessageListener(
        consumerGroup = Constant.CONSUMER_GROUP,
        topic = Constant.TOPIC_SYNCSEND
)
public class RocketMqConsumer_SyncSend implements RocketMQListener<MessageExt>, RocketMQPushConsumerLifecycleListener {

    @Override
    public void onMessage(MessageExt messageExt) {
        String msg = null;
        try {
            msg = new String(messageExt.getBody(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("MsgConsumer >>> " + msg + ", msgId = " + messageExt.getMsgId());

    }

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {

    }
}
