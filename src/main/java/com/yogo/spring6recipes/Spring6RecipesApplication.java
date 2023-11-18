package com.yogo.spring6recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring6RecipesApplication {
	@Autowired
	private MessageSource messageSource;

	public static void main(String[] args) {
		SpringApplication.run(Spring6RecipesApplication.class, args);
	}

	@Bean
	public ApplicationRunner init() {
		return (args) -> {
			

		};
	}


}
