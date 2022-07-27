package com.example.zdy_demo.service;

import java.util.Map;

public interface RabbitMQService {

    String sendMsg(String msg);

    String sendMsgByFanoutExchange(String msg);

    String sendMsgByTopicExchange(String msg, String routingKey);

    String sendMsgByHeadersExchange(String msg, Map<String, Object> map);
}
