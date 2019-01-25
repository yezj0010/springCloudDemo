package com.tomcat360.websocket.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * webSocket配置
 * js库
 * https://www.bootcdn.cn/
 *
 * 前端调用方式： var socket = new SockJS('http://localhost:9041/discovery/tradePoint');
 *             var stompClient = Stomp.over(socket);
 *
 *             stompClient.connect({}, function(frame) {
 *                  setConnected(true);
 *                  console.log('Connected: ' + frame);
 *
 *                  stompClient.subscribe('/topic/messages', function(messageOutput) {
 *                      showMessageOutput(JSON.parse(messageOutput.body));
 *                  });
 *             });
 *
 *             function disconnect() {
 *                   if(stompClient != null) {
 *                      stompClient.disconnect();
 *                   }
 *                   setConnected(false);
 *                   console.log("Disconnected");
 *                  }
 *            function sendMessage() {
 *                  var from = document.getElementById('from').value;
 *                  var text = document.getElementById('text').value;
 *                  stompClient.send("/app/chat", {}, JSON.stringify({'from': from,'text': text}));
 *                  }
 *           function showMessageOutput(messageOutput) {
 *                 var response = document.getElementById('response');
 *                 var p = document.createElement('p');
 *                 p.style.wordWrap = 'break-word';
 *                 p.appendChild(document.createTextNode(messageOutput.from + ": " +messageOutput.text + " (" + messageOutput.time + ")"));
 *                 response.appendChild(p);
 *                 }
 * @author xb on 2018/3/9 0009.
 */
@Configuration
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
//        // 添加服务端点，可以理解为某一服务的唯一key值
//        stompEndpointRegistry.addEndpoint("Api-WebSocket/tradePoint","/tradePoint").setAllowedOrigins("*");
//        //当浏览器支持sockjs时执行该配置
//        stompEndpointRegistry.addEndpoint("Api-WebSocket/tradePoint","/tradePoint")
//                .setAllowedOrigins("*").withSockJS();


        //注册一个Stomp的节点（endpoint）,并指定使用SockJS协议。记得设置跨域
        stompEndpointRegistry.addEndpoint("/yezjEndpoint").setAllowedOrigins("*").withSockJS();
    }

    /**
     * 内存代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //服务端发送消息给客户端的域,多个用逗号隔开,//广播式应配置一个/topic消息代理
        registry.enableSimpleBroker("/topic","/topic2","/user");
        //定义一对一推送的时候前缀
        registry.setUserDestinationPrefix("/user");
        //定义websoket前缀
        registry.setApplicationDestinationPrefixes("/app-send");
    }

//    /**
//     * 真正的stomp代理
//     * @param registry
//     */
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        // 启用了 STOMP 代理中继功能，并将其代理目的地前缀设置为 /topic and /queue .
//        registry
//                .enableStompBrokerRelay("/topic", "/topic2")
//                .setRelayPort(18888)
//                .setClientLogin("admin")
//                .setClientPasscode("admin");
//        //定义websoket前缀
//        registry.setApplicationDestinationPrefixes("/app-send");
//    }

    // --------------以下配置是返回数据将bigdecimal转换成string返回--------------

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        //messageConverters.add(toStringConverter());
        return true;
    }

    @Bean
    public MappingJackson2MessageConverter toStringConverter(){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(BigDecimal.class, BigDecimalToStringSerializer.instance);
        mapper.registerModule(simpleModule);
        converter.setObjectMapper(mapper);
        return converter;
    }

    @JacksonStdImpl
    static class BigDecimalToStringSerializer extends ToStringSerializer {
        public final static WebSocketConfig.BigDecimalToStringSerializer instance = new WebSocketConfig.BigDecimalToStringSerializer();

        public BigDecimalToStringSerializer() {
            super(Object.class);
        }

        @Override
        public boolean isEmpty(SerializerProvider prov, Object value) {
            if (value == null) {
                return true;
            }
            String str = ((BigDecimal) value).stripTrailingZeros().toPlainString();
            return str.isEmpty();
        }

        @Override
        public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
                throws IOException {
            gen.writeString(((BigDecimal) value).stripTrailingZeros().toPlainString());
        }

        @Override
        public void serializeWithType(Object value, JsonGenerator gen,
                                      SerializerProvider provider, TypeSerializer typeSer)
                throws IOException {
            serialize(value, gen, provider);
        }
    }
}
