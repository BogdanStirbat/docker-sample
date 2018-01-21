package com.bstirbat.sample.docker.name.controller;

import com.bstirbat.sample.docker.name.entity.Name;
import com.bstirbat.sample.docker.name.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NameController {

    private static final String GET_KEY = "GET_KEY";
    private static final String POST_KEY = "POST_KEY";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private NameRepository nameRepository;

    @GetMapping("/name/{id}")
    @ResponseBody
    public Name findById(@PathVariable Long id) {
        String numberOfGetsString = redisTemplate.opsForValue().get(GET_KEY);
        Integer numberOfGets = numberOfGetsString == null? null: Integer.valueOf(numberOfGetsString);
        if (numberOfGets == null) {
            numberOfGets = 0;
        }
        numberOfGets++;
        redisTemplate.opsForValue().set(GET_KEY, numberOfGets.toString());

        return nameRepository.findById(id).orElseThrow(() -> new RuntimeException("Cannot find a name with id: " + id));
    }

    @PostMapping("/name")
    @ResponseBody
    public Name addName(@RequestBody Name name) {
        String numberOfPostsString = redisTemplate.opsForValue().get(POST_KEY);
        Integer numberOfPosts = numberOfPostsString == null? null: Integer.valueOf(numberOfPostsString);
        if (numberOfPosts == null) {
            numberOfPosts = 0;
        }
        numberOfPosts++;
        redisTemplate.opsForValue().set(POST_KEY, numberOfPosts.toString());

        return nameRepository.save(name);
    }
}
