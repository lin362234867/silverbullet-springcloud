package com.tianque.controller;

import com.tianque.api.HelloApi;
import com.tianque.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * handler method 参数绑定常用的注解,我们根据他们处理的Request的不同内容部分分为四类：（主要讲解常用类型）
 A、处理requet uri 部分（这里指uri template中variable，不含queryString部分）的注解：   @PathVariable;
 B、处理request header部分的注解：   @RequestHeader, @CookieValue;
 C、处理request body部分的注解：@RequestParam,  @RequestBody;
 D、处理attribute类型是注解： @SessionAttributes, @ModelAttribute;
 */
@RequestMapping("/")
@RestController
public class HelloController implements HelloApi{
    private static Logger log = LoggerFactory.getLogger(HelloController.class);

    @Override
    public Integer hello1() {
        log.info("555555555555555555");
        return 1;
    }

    public String hello(){
        log.info("123124");
        return "hello";
    }

    public String hello(@RequestParam String name){
        log.info("==================hello" +name);
        return "hello" + name;
    }

    public String hello(@RequestBody User user){
        return "hello" + user.getName();
    }

}
