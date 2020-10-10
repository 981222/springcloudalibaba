package com.huang.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConsumerConfiguration {

    @Bean
    // @LoadBalanced 负载均衡， 添加ribbon，ribbon的底层也是restTemplate
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
