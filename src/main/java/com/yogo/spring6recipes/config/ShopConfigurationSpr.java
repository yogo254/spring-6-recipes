package com.yogo.spring6recipes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yogo.spring6recipes.models.product.Battery;
import com.yogo.spring6recipes.models.product.Disc;
import com.yogo.spring6recipes.models.product.Product;

@Configuration
@Profile({ "spring" })
public class ShopConfigurationSpr {
	@Bean
	public Product aaa() {
		return new Battery("AAA", 4.5, true);
	}

	@Bean
	public Product cdrw() {
		return new Disc("CD-RW", 1.5, 700d);
	}

	@Bean
	public Product dvdrw() {
		return new Disc("DVD-RW", 3.0, 4700d);
	}
}
