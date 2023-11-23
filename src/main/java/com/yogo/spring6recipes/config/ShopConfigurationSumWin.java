package com.yogo.spring6recipes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.yogo.spring6recipes.models.product.Battery;
import com.yogo.spring6recipes.models.product.Disc;
import com.yogo.spring6recipes.models.product.Product;

@Configuration
@Profile({ "summer", "winter" })
public class ShopConfigurationSumWin {
	@Bean
	public Product aaa() {
		return new Battery("AAA", 2.0, true);
	}

	@Bean
	public Product cdrw() {
		return new Disc("CD-RW", 1.0, 700.0);
	}

	@Bean
	public Product dvdrw() {
		return new Disc("DVD-RW", 2.5, 4700.0);
	}

}
