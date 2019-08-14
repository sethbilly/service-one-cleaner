package com.partner.one.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ServiceOneApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceOneApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
		LOGGER.info("Service One Application.............");
	}

}
