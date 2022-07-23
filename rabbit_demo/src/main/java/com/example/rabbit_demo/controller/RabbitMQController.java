package com.example.rabbit_demo.controller;

import com.example.rabbit_demo.service.RabbitMQService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/mall/rabbitmq")
public class RabbitMQController {

    @Resource
    private RabbitMQService rabbitMQService;

    /**
     * 发送消息 Direct交换机
     *
     */
    @PostMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "msg") String msg) throws Exception {
        return rabbitMQService.sendMsg(msg);
    }

    /**
     *  发布消息 Fanout交换机
     * @param msg
     * @return
     * @throws Exception
     */
    @PostMapping("/sendFanout")
    public String sendFanout(@RequestParam(name = "msg") String msg) throws Exception {
        return rabbitMQService.sendMsgByFanoutExchange(msg);
    }

    /**
     * 发布消息 topic
     *
     */
    @PostMapping("/sendTopic")
    public String sendTopic(@RequestParam(name = "msg") String msg, @RequestParam(name = "routingKey") String routingKey) throws Exception {
        return rabbitMQService.sendMsgByTopicExchange(msg, routingKey);
    }

    /**
     * 发布消息 headers
     * @param msg
     * @param json
     * @return
     * @throws Exception
     */
    @PostMapping("/sendHeaders")
    @SuppressWarnings("unchecked")
    public String sendHeaders(@RequestParam(name = "msg") String msg,
                              @RequestParam(name = "json") String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(json, Map.class);
        return rabbitMQService.sendMsgByHeadersExchange(msg, map);
    }
}
