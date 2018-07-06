package com.tianque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by QQ on 2018/7/6.
 */
@RestController
public class ConsulClientController {
    @Autowired
    private RestTemplate template;
    @RequestMapping("/consulClient")
    public String hello(){
        return template.getForEntity("http://consul-provider/hello",String.class).getBody();
    }
}
