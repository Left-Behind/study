package work.azhu.springbootkafkaconsumer.consumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: Xiaour
 * @Description:
 * @Date: 2018/5/22 15:03
 */
@Component
public class Consumer {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record){

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();
            JSONObject userJson = JSONObject.parseObject(message.toString());
            Message message1 = JSON.toJavaObject(userJson,Message.class);
            System.out.println(message1.getMsg());
            System.out.println("---->"+record);
            System.out.println("---->"+message);

        }

    }
}
