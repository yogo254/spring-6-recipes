package com.yogo.spring6recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.yogo.spring6recipes.models.product.Product;

@SpringBootApplication
public class Spring6RecipesApplication {
	@Autowired
	@Qualifier("aaa")
	private Product product;

	public static void main(String[] args) {
		SpringApplication.run(Spring6RecipesApplication.class, args);
	}

	@Bean
	public ApplicationRunner init() {
		return (args) -> {

			System.out.println(product);
			

		};
	}


}
