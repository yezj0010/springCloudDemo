package com.tomcat360.admin.mq;


import com.tomcat360.admin.constant.MqQueueConstant;
import com.tomcat360.admin.model.mq.BaseMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * mq监听
 *
 * @author on 2018/11/1
 */
@Slf4j
@Configuration
public class MqTestListener {

    /**
     * 处理mq队列信息
     *
     * @param baseMessage
     */
    @RabbitListener(queues = MqQueueConstant.TEST, containerFactory = "rabbitListenerContainerFactory")
    public void processNomal(@Payload BaseMessage baseMessage) {
        try {
            log.info("接收到test消息：" + baseMessage);
        } catch (Exception e) {
            log.error("接收test消息异常", e);
        }
    }

    /**
     * 处理mq超时队列信息
     *
     * @param baseMessage
     */
    @RabbitListener(queues = MqQueueConstant.TEST_DELAY_HANDLE, containerFactory = "rabbitListenerContainerFactory")
    public void processTimeout(@Payload BaseMessage baseMessage) {
        try {
            log.info("接收到test_delay_handle消息：" + baseMessage);
        } catch (Exception e) {
            log.error("接收test_delay_handle消息异常", e);
        }
    }
}
