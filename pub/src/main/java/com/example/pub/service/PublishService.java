package com.example.pub.service;

import com.example.pub.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    Logger log = LoggerFactory.getLogger(PublishService.class);
    private final RedisTemplate<String,Object> redisTemplate;

    private final ChannelTopic channelTopic;

    public PublishService(RedisTemplate<String, Object> redisTemplate, ChannelTopic channelTopic) {
        this.redisTemplate = redisTemplate;
        this.channelTopic = channelTopic;
    }

    public Long publish(Product product){
        log.info("Sending message Sync: {}", product);
        return redisTemplate.convertAndSend(channelTopic.getTopic(), product);
    }
}
