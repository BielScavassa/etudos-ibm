package com.ibm.springcloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;
import feign.Request;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class FeignConfiguration {

	@Bean
	public Logger.Level configureLoggerLevel(){
		return Logger.Level.FULL;
	}
	
	@Bean
	public Request.Options timeoutConfiguration(){
		return new Request.Options(5000, 30000);
	}
	
	@Bean
	public Retryer retryer() {
		return new Retryer.Default(1000, 8000, 3);
	}
}
