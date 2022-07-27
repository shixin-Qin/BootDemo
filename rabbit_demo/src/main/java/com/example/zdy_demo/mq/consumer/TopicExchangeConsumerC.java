package com.example.zdy_demo.mq.consumer;

import com.example.zdy_demo.mq.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_C))
public class TopicExchangeConsumerC {

    @RabbitHandler
    public void process(@Payload Map<String, Object> map) {
        log.info("topic:队列[" + RabbitMQConfig.TOPIC_EXCHANGE_QUEUE_C + "]收到消息：{}" + map.toString());
    }
}
