package com.wendelNeres.EventsMicroservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EventsMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsMicroservicesApplication.class, args);
	}

}
