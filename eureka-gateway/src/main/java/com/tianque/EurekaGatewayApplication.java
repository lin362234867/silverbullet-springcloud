package com.tianque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableWebFlux
@SpringBootApplication
public class EurekaGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaGatewayApplication.class, args);
	}
}
