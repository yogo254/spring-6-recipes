package com.yogo.spring6recipes.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.yogo.spring6recipes.models.component.Cashier;

@Configuration
public class ShopConfigurationGlobal {
	@Bean
	@Primary
	public MessageSource messageSource() {
		var messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setCacheSeconds(1);
		return messageSource;
	}

	@Bean(initMethod = "openFile", destroyMethod = "closeFile")
	public Cashier cashier() {
		var path = System.getProperty("java.io.tmpdir") + "/cashier";
		return new Cashier("checkout", path);
	}

}
