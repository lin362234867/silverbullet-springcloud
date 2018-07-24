package com.tianque.fallback;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QQ on 2018/7/16.
 */
@RestController
public class ConsulProviderHystrix {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hystrixTimeout")
    public JSONObject hystrixTimeout() {
        log.error("i5xforyou-service-gateway触发了断路由");
        return new JSONObject();
    }

    @HystrixCommand(commandKey="authHystrixCommand")
    public JSONObject authHystrixCommand() {
        return new JSONObject();
    }
}
