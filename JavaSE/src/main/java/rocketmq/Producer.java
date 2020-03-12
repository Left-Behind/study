package rocketmq;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;
import java.net.URLClassLoader;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author Azhu
 * @Date 2019/12/30 18:28
 * @Description
 */
public class Producer {

    public static void main(String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        // 设置生产者组名
        DefaultMQProducer producer = new DefaultMQProducer("my_producer_group");
        // 设置NameServer地址
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 启动
        producer.start();
        for (int i = 0; i < 10; i++) {
            // 创建一条消息，包含topic、tag以及消息内容
            Message msg;

            msg = new Message("TopicTest", "MyTag+"+System.currentTimeMillis()/1000, ("Hello RocketMQ "+ Calendar.getInstance()).getBytes());
            msg.setDelayTimeLevel(2);
            // 发送结果
            SendResult sendResult = producer.send(msg);

            System.out.printf("%s%n", sendResult);
        }
        // 不用的时候关闭
        producer.shutdown();
    }
}
