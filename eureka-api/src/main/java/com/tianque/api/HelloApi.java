package com.tianque.api;

import com.tianque.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * 为了能够能好的复用DTo和接口的复用
 */
@RequestMapping("/helloApi")
public interface HelloApi {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String hello(@RequestBody User user);

}
