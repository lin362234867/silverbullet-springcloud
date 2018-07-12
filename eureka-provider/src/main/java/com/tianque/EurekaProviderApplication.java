package com.tianque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//hystrix.stream必须加的部分
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class EurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}
}
