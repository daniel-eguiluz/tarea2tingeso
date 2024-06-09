package com.tutorial.precioreparacionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PrecioReparacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrecioReparacionServiceApplication.class, args);
	}

}
