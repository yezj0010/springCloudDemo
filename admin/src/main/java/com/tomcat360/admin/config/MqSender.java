package com.tomcat360.admin.config;

import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mqSender")
public class MqSender {  
  
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息到mq
     * @param queueName
     * @param msg
     */
    public void send(String queueName, Object msg) {
        this.rabbitTemplate.convertAndSend(queueName, msg);
    }

    /**
     * 发送信息到延迟队列
     *
     * @param msg    参数
     * @param delayTime 延迟时间单位为毫秒
     */
    public void send(String queue, Object msg, Integer delayTime) {
        rabbitTemplate.convertAndSend(queue, msg, (message) -> {
            message.getMessageProperties().setExpiration(delayTime.toString());
            message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
            return message;
        });
    }
}  
