package com.tianque.api;

import com.tianque.dto.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 为了能够能好的复用DTo和接口的复用
 */
public interface HelloApi {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello();

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name);

    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String hello(@RequestBody User user);

}
