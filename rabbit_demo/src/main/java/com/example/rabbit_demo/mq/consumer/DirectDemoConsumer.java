package com.example.rabbit_demo.mq.consumer;

import com.example.rabbit_demo.mq.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
//使用queuesToDeclare属性，如果不存在则会创建队列
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC))
public class DirectDemoConsumer {

    @RabbitHandler
    public void handle(@Payload Map map) {
        log.info("direct:消费消息:{}", map.toString());
    }
}
