package com.tomcat360.admin.config;

import com.tomcat360.admin.constant.MqQueueConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MQ配置
 *
 * @author
 */
@Configuration
public class AmqpConfig {

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setPrefetchCount(200);
        factory.setConcurrentConsumers(100);
        // 关键所在，指定线程池默认为100
        ExecutorService service = Executors.newFixedThreadPool(500);
        factory.setTaskExecutor(service);
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }

    @Bean("testQueue")
    public Queue testQueue() {
        return new Queue(MqQueueConstant.TEST);
    }

    /**
     * 超时队列
     * 超时队列中，消息超时成为死信后，路由到对应交换机和key绑定的队列
     * @return
     */
    @Bean("orderTimeOutDelayQueue")
    public Queue testDelayQueue() {
        Map<String, Object> params = new HashMap<>();
        // x-dead-letter-exchange 声明了队列里的死信转发到的DLX名称，
        params.put("x-dead-letter-exchange", MqQueueConstant.TEST_DELAY_EXCHCHANGE);
        // x-dead-letter-routing-key 声明了这些死信在转发时携带的 routing-key 名称。
        params.put("x-dead-letter-routing-key", MqQueueConstant.TEST_DELAY_HANDLE_KEY);
        return new Queue(MqQueueConstant.TEST_DELAY,true, false, false, params);
    }

    /**
     * 超时处理队列，成为死信后，消息路由到此队列
     * @return
     */
    @Bean("testDelayHandleQueue")
    public Queue testDelayHandleQueue() {
        return new Queue(MqQueueConstant.TEST_DELAY_HANDLE);
    }

    // 延时后转发交换机
    @Bean
    DirectExchange testDelayHandleExchange(){
        return new DirectExchange(MqQueueConstant.TEST_DELAY_EXCHCHANGE,true,false);
    }

    // 绑定处理队列与延迟后转发交换机
    @Bean
    public Binding testDelayHandelBind() {
        return BindingBuilder.bind(testDelayHandleQueue()).to(testDelayHandleExchange()).with(MqQueueConstant.TEST_DELAY_HANDLE_KEY);
    }

}
