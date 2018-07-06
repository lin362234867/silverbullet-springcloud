package com.tianque.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QQ on 2018/7/6.
 */
@RestController
public class ConsulProvider {
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String hello() {
        return "Hello world";
    }
}
