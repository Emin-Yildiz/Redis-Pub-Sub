package com.example.pub.controller;

import com.example.pub.domain.Product;
import com.example.pub.service.PublishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private final PublishService publishService;

    public RedisController(PublishService publishService) {
        this.publishService = publishService;
    }

    @PostMapping("/publish")
    public String publish(@RequestBody Product item) {
        publishService.publish(item);
        return "Success";
    }
}
