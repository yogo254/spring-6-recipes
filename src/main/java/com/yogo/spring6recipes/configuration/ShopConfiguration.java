package com.yogo.spring6recipes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yogo.spring6recipes.builder.ProductCreator;
import com.yogo.spring6recipes.models.product.Product;

@Configuration
public class ShopConfiguration {
	@Bean
	public Product aaa() {
		return ProductCreator.createProduct("aaa");
	}

	@Bean
	public Product cdrw() {
		return ProductCreator.createProduct("cdrw");
	}

	@Bean
	public Product dvdrw() {
		return ProductCreator.createProduct("dvdrw");
	}

}
