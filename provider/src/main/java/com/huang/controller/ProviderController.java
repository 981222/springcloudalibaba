package com.huang.controller;

import com.huang.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/list")
    public String lll(){
        return "list";
    }

    @GetMapping("/test1")
    public String test1(){
        this.providerService.test();
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        this.providerService.test();
        return "test2";
    }
}
