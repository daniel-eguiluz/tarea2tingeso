package com.tutorial.registrodereparacionesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RegistroDeReparacionesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroDeReparacionesServiceApplication.class, args);
	}

}
