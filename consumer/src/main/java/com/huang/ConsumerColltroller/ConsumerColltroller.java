package com.huang.ConsumerColltroller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@Slf4j
public class ConsumerColltroller {
    //自动装载，所以直接用
    @Autowired
    private DiscoveryClient discoveryClient;

    //不会自动装载，不能直接用，需要在启动类配置bean
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/instances")
    public List<ServiceInstance> instances(){
        List<ServiceInstance> list = this.discoveryClient.getInstances("provider");
        return list;
    }

//    使用原生RestTemplate的方法进行调用其他服务的接口
//    @GetMapping("/index")
//    public String index(){
//        //调用provider服务中的index方法
//        //1.找到provider实例
//        List<ServiceInstance> provider = this.discoveryClient.getInstances("provider");
//        int index = ThreadLocalRandom.current().nextInt(provider.size());
//        ServiceInstance serviceInstance = provider.get(index);
//        String url = serviceInstance.getUri() + "/index";
//        //2.调用
//        log.info("调用的端口是，{}", serviceInstance.getPort());
//        return "调用了端口为：" + serviceInstance.getPort() + "的服务，返回结果为：" + this.restTemplate.getForObject(url, String.class);
//    }

//    使用ribbon（RestTemplate的上一层封装）的方法进行调用其他服务的接口
    @GetMapping("/index")
    public String index(){
        return this.restTemplate.getForObject("http://provider/index", String.class);
    }
}
