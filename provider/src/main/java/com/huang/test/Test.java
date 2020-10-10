package com.huang.test;

import org.springframework.web.client.RestTemplate;

public class Test {
    public static void main(String[] args) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        for (int i = 0; i < 1000; i++){
            restTemplate.getForObject("http://localhost:8081/list", String.class);
            Thread.sleep(200);
        }
    }
}
