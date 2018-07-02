package com.tianque.controller;

import com.tianque.service.EurekaClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QQ on 2018/6/26.
 */
@RestController
public class EurekaClientController {
    @Autowired
    EurekaClientService eurekaClientService;
    @RequestMapping(value = "/ribbontest",method = RequestMethod.GET)
    public String doService(){
        return eurekaClientService.doService();
    }
}
