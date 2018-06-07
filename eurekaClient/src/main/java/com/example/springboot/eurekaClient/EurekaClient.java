package com.example.springboot.eurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
@EnableEurekaServer
public class EurekaClient {
	

	public static void main(String[] args) {
		SpringApplication.run(EurekaClient.class, args);
	}

}
