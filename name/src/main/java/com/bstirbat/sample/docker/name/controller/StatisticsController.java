package com.bstirbat.sample.docker.name.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatisticsController {

    private static final String GET_KEY = "GET_KEY";
    private static final String POST_KEY = "POST_KEY";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/statistics")
    public String statistics() {
        String numberOfGets = redisTemplate.opsForValue().get(GET_KEY);
        String numberOfPosts = redisTemplate.opsForValue().get(POST_KEY);

        return  "{" + "GET: " + numberOfGets + ", POST: " + numberOfPosts + "}";
    }
}
