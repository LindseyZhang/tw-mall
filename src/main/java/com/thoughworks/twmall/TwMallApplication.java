package com.thoughworks.twmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TwMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwMallApplication.class, args);
	}
}
