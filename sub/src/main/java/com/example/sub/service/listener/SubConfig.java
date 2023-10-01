package com.example.sub.service.listener;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class SubConfig {

    private final MessageListener messageListener;
    private final MessageListener messageListener2;
    private final MessageListener messageListener3;
    private final LettuceConnectionFactory connectionFactory;

    public SubConfig(@Qualifier("producEventListener") MessageListener messageListener, @Qualifier("producEventListener2") MessageListener messageListener2, @Qualifier("producEventListener3") MessageListener messageListener3, LettuceConnectionFactory connectionFactory) {
        this.messageListener = messageListener;
        this.messageListener2 = messageListener2;
        this.messageListener3 = messageListener3;
        this.connectionFactory = connectionFactory;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter() {
        return new MessageListenerAdapter(messageListener);
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter2() {
        return new MessageListenerAdapter(messageListener2);
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter3() {
        return new MessageListenerAdapter(messageListener3);
    }

    @Bean
    public RedisMessageListenerContainer redisContainer(ChannelTopic topic) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListener, topic);
        container.addMessageListener(messageListener2, topic);
        container.addMessageListener(messageListener3, topic);
        return container;
    }
}
