package com.yogo.spring6recipes.models.calculator;

import org.springframework.stereotype.Service;

@Service
public class StandardArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public double add(double a, double b) {
		var result = a + b;
		System.out.printf("%f / %f = %f%n", a, b, result);
		return result;
	}

	@Override
	public double sub(double a, double b) {
		var result = a - b;
		System.out.printf("%f / %f = %f%n", a, b, result);
		return result;
	}

	@Override
	public double mul(double a, double b) {
		var result = a * b;
		System.out.printf("%f / %f = %f%n", a, b, result);
		return result;
	}

	@Override
	public double div(double a, double b) {
		if (b == 0) {
			throw new IllegalArgumentException("Division by 0");
		}
		var result = a / b;
		System.out.printf("%f / %f = %f%n", a, b, result);
		return result;
	}

}
