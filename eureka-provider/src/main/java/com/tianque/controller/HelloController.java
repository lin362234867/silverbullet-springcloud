package com.tianque.controller;

import com.tianque.api.HelloApi;
import com.tianque.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * handler method 参数绑定常用的注解,我们根据他们处理的Request的不同内容部分分为四类：（主要讲解常用类型）
 A、处理requet uri 部分（这里指uri template中variable，不含queryString部分）的注解：   @PathVariable;
 B、处理request header部分的注解：   @RequestHeader, @CookieValue;
 C、处理request body部分的注解：@RequestParam,  @RequestBody;
 D、处理attribute类型是注解： @SessionAttributes, @ModelAttribute;
 */
@RestController
public class HelloController implements HelloApi{

    public String hello(){
        return "hello";
    }

    public String hello(@RequestParam String name){
        try {
            Thread.sleep(2005);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello" + name;
    }

    public String hello(@RequestBody User user){
        return "hello" + user.getName();
    }

}
