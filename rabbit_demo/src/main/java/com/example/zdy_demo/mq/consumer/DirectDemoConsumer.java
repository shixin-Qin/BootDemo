package com.example.zdy_demo.mq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Map;

@Slf4j
//@Component
////使用queuesToDeclare属性，如果不存在则会创建队列
//@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.RABBITMQ_DEMO_TOPIC),concurrency = "10")
public class DirectDemoConsumer {

    @RabbitHandler
    public void handle(@Payload Map map) {
        log.info("direct:消费消息1:{}", map.toString());
    }
}
