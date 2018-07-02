package com.tianque.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by QQ on 2018/6/27.
 */
@Service
public class EurekaClientService {
    @Autowired
    RestTemplate restTemplate;
    //fallbackMethod为服务降级方法，在不需要返回结果的情况下可以不应用服务降级
    //可以设置groupKey和threadPoolKey做线程隔离，粗粒度为group的，细粒度为线程key，同一组或同一线程池key的共用同一个线程池
    @HystrixCommand(commandKey = "doService",fallbackMethod = "doServiceFallback")
    public String doService(){
        return restTemplate.getForEntity("http://EUREKA-PROVIDER/hello",String.class).getBody();
    }
    //降级方法中增加参数throwable对象，可以捕获调用服务过程中抛出的异常
    public String doServiceFallback(Throwable throwable){
        return  "error";
    }
}
