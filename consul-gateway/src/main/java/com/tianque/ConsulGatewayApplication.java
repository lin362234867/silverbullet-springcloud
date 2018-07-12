package com.tianque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableAutoConfiguration
@EnableWebFlux
@EnableDiscoveryClient
@ComponentScan("com.tianque")
@SpringBootApplication
public class ConsulGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsulGatewayApplication.class, args);
	}
}
