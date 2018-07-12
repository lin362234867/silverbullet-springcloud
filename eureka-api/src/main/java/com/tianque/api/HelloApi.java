package com.tianque.api;

import com.tianque.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * 为了能够能好的复用DTo和接口的复用
 */
public interface HelloApi {
    @GetMapping(value = "hello")
    public String hello();

    @GetMapping(value = "hello1")
    public String hello(@RequestParam("name") String name);

    @PostMapping(value = "hello2")
    public String hello(@RequestBody User user);

    @GetMapping(value = "hello4")
    public Integer hello1();

}
