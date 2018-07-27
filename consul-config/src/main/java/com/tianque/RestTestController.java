package com.tianque;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by QQ on 2018/7/27.
 */
@Data
@RestController
public class RestTestController {
    @Value("${test}")
    private String test;
    @GetMapping("/test")
    public String test(){
        return test;
    }
}
