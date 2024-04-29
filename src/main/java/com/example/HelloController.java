package com.example;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/posts")
    public ResponseEntity<String> createPost(@RequestBody PostRequestBody postRequestBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PostRequestBody> requestEntity = new HttpEntity<>(postRequestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(JSON_PLACEHOLDER_URL, requestEntity, String.class);

        return ResponseEntity.ok(responseEntity.getBody());
    }
}