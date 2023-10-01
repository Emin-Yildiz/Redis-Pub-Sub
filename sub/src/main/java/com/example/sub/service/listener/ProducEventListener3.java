package com.example.sub.service.listener;

import com.example.sub.domain.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("producEventListener3")
public class ProducEventListener3 implements MessageListener {

    Logger log = LoggerFactory.getLogger(ProducEventListener2.class);

    private final ObjectMapper objectMapper;

    private final RedisTemplate<String,Object> redisTemplate;

    public ProducEventListener3(ObjectMapper objectMapper, RedisTemplate<String, Object> redisTemplate) {
        this.objectMapper = objectMapper;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        log.info(String.format("new message received productEventListener3: %s", message.toString()));
        try {
            Product item = objectMapper.readValue(message.getBody(), Product.class);
            redisTemplate.opsForValue().set(String.valueOf(item.getProductId()),item);
            log.info(String.format( "Item Subscribe operations is success: %s",item));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
