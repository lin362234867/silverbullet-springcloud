package com.tianque.api;

import com.tianque.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QQ on 2018/7/6.
 */
@RestController
public class ConsulProvider {
    @GetMapping(value = "hello")
    public void hello() {
        System.out.println("hello world");
    }

    @GetMapping(value = "hello1")
    public String hello1() {
        return "12345";
    }

    @GetMapping(value = "hello2")
    public User hello2() {
        return  new User("name",1);
    }
}
