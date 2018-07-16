package com.tianque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
@ComponentScan("com.tianque")
public class AuthorizationServerApplication {



	public static void main(String[] args) {

		SpringApplication.run(AuthorizationServerApplication.class, args);
	}
}
