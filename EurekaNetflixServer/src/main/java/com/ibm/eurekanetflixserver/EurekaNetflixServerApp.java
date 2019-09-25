package com.ibm.eurekanetflixserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaNetflixServerApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaNetflixServerApp.class, args);
	}

}
