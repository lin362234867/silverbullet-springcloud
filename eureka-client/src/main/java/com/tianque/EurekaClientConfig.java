package com.tianque;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * Created by QQ on 2018/6/26.
 */
//开启断路器功能
@EnableCircuitBreaker
//eureka客户端配置也可使用@EnableDiscoveryClient
@EnableEurekaClient
@Configuration

public class EurekaClientConfig {
    @Bean
    //被@LoadBalanced注释修饰过的RestTemplate可以直接调用服务，且能开启客户端负载均衡
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
