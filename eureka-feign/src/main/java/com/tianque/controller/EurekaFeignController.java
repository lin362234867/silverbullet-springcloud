package com.tianque.controller;

import com.tianque.dto.User;
import com.tianque.service.EurekaFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QQ on 2018/6/29.
 */
@RestController
public class EurekaFeignController {
    @Autowired
    EurekaFeignService eurekaFeignService;
    @RequestMapping("/feignHello")
    public String feignHello(){
        return eurekaFeignService.hello();
    }
    @RequestMapping("/feignHello1")
    public String feignHello1(){
        return eurekaFeignService.hello("linlinan");
    }
    @RequestMapping("/feignHello2")
    public String feignHello2(){
        User user = new User();
        user.setName("huangyingqi");
        return eurekaFeignService.hello(user);
    }
}
