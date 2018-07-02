package com.tianque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringCloudApplication等于@SpringBootApplication+@EnableDiscoveryClient+@EnableCircuitBreaker
@SpringBootApplication
public class EurekaClientApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
