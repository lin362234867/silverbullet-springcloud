package com.tianque.service;

import com.tianque.dto.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@RequestMapping("/fallback/helloapi")
public class EurekaFeignFallback implements EurekaFeignService{
    @Override
    public String hello() {
        return "error";
    }

    @Override
    public String hello(@RequestParam("name") String name) {
        return "error";
    }

    @Override
    public String hello(@RequestBody User user) {
        return "error";
    }

    @Override
    public Integer hello1() {
        return null;
    }
}
