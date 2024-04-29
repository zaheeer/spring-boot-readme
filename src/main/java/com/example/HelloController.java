package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @RequestMapping("/health")
    String hello() {
        return "Server is Up...!";
    }

    private final String JSON_PLACEHOLDER_URL = "https://jsonplaceholder.typicode.com/posts";

    @GetMapping("/posts")
    public String getPostFromJSONPlaceholder() {
        RestTemplate restTemplate = new RestTemplate();
        String post = restTemplate.getForObject(JSON_PLACEHOLDER_URL, String.class);
        return post;
    }
}