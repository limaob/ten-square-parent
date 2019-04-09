package com.ten.square.article.qa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import uitl.IdWorker;
@SpringBootApplication
public class QAApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.ten.square.qa.QAApplication.class, args);
	}

	@Bean
	public IdWorker idWorkker(){
		return new IdWorker(1, 1);
	}
	
}
