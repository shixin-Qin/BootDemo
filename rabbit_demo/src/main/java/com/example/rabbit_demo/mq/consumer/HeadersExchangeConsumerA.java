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

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RabbitListener(queuesToDeclare = @Queue(RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A))
public class HeadersExchangeConsumerA {

    @RabbitHandler
    public void process(byte[] result) throws Exception {
        /*MessageProperties messageProperties = message.getMessageProperties();
        String contentType = messageProperties.getContentType();
        log.info("headers:队列A[" + RabbitMQConfig.HEADERS_EXCHANGE_QUEUE_A + "]收到消息：{}", new String(message.getBody(), contentType));*/
        String message = new String(result, StandardCharsets.UTF_8.name());
        System.out.println(message);
    }
}
