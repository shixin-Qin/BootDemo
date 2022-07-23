package com.example.rabbit_demo.mq.consumer;

import com.example.rabbit_demo.mq.RabbitMQConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_B))
public class HeadersExchangeConsumerB {

    @RabbitHandler
    public void process(@Payload Map<String, Object> map) throws Exception {
        log.info("headers:队列B[" + RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A + "]收到消息：{}", map);
    }
}
