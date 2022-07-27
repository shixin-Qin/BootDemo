package com.example.zdy_demo.mq.consumer;

import com.example.zdy_demo.mq.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
//使用queuesToDeclare属性，如果不存在则会创建队列
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC),ackMode = "MANUAL")
public class DirectDemoConsumeT {

    Map<String,Integer> msgIdMap =  new HashMap<>();

    @RabbitHandler
    public void handle(@Payload Map map, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {
        log.info("direct:消费消息2:{}", map.toString());
        String msgId = (String) map.get("msgId");
        if (map.containsValue("success")) {
            // RabbitMQ的ack机制中，第二个参数返回true，表示需要将这条消息投递给其他的消费者重新消费
            channel.basicAck(deliveryTag, false);
        }
        else {
            Integer retryCount = msgIdMap.get(msgId);
            // 第三个参数true，表示这个消息会重新进入队列
            if( msgIdMap.containsKey(msgId)){
                if(retryCount <= 3)
                {
                    retryCount++;
                    msgIdMap.put(msgId,retryCount);
                    channel.basicNack(deliveryTag, false, true);
                }
                else
                    channel.basicNack(deliveryTag, false, false);
            }else {
                msgIdMap.put(msgId,1);
                channel.basicNack(deliveryTag, false, true);
            }
        }

    }
}
