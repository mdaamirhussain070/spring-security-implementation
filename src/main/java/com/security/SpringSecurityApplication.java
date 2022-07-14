package com.security;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringSecurityApplication {
	
	private static final Logger logger=LoggerFactory.getLogger(SpringSecurityApplication.class);
	public static void main(String[] args) {
		logger.info("Application Started");
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	public ModelMapper modelMaper() {
		
		return new ModelMapper();
	}

}
