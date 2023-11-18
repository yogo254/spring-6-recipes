package com.yogo.spring6recipes.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.yogo.spring6recipes.models.product.Product;

/**
 * ProductCheckBeanPostProcessor
 */

public class ProductCheckBeanPostProcessor implements BeanPostProcessor {
	private static final String message = "In ProductCheckBeanPostProcessor.%s, processing Product: %s%n";

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Product product) {
			var productName = product.getName();
			System.out.printf(message, "postProcessBeforeInitialization", productName);
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Product product) {
			var productName = product.getName();
			System.out.printf(message, "postProcessAfterInitialization", productName);
		}
		return bean;
	}

}