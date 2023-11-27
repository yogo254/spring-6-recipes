package com.yogo.spring6recipes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yogo.spring6recipes.models.calculator.ArithmeticCalculator;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Spring6RecipesApplication {
	@Autowired
	private ArithmeticCalculator arithmeticCalculator;

	public static void main(String[] args) {
		SpringApplication.run(Spring6RecipesApplication.class, args);
	}

	@Bean
	public ApplicationRunner init() {
		return args -> {
			var a = 3;
			var b = 5;

			System.out.println("Addition result "+  arithmeticCalculator.add(a, b));
			System.out.println("Subtraction result "+  arithmeticCalculator.sub(a, b));

		};
	}

}
