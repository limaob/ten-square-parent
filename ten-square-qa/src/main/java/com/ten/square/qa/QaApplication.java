package com.ten.square.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uitl.IdWorker;
@SpringBootApplication
public class QaApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.ten.square.qa.QaApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
