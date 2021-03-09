package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootEureka2ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEureka2ConsumerApplication.class, args);
	}

}
