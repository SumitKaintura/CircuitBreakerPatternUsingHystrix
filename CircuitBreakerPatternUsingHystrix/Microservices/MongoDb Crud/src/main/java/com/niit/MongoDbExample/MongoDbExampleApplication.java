package com.niit.MongoDbExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MongoDbExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbExampleApplication.class, args);
	}

}
