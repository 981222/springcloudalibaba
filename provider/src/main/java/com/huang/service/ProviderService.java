package com.huang.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

public class ProviderService {

    @SentinelResource("test")
    public void test(){
        System.out.println("test");
    }
}
