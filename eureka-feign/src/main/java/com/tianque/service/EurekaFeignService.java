package com.tianque.service;

import com.tianque.api.HelloApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * Created by QQ on 2018/6/29.
 */
@FeignClient(name="EUREKA-PROVIDER" ,fallback = EurekaFeignFallback.class)
public interface EurekaFeignService extends HelloApi{

}
