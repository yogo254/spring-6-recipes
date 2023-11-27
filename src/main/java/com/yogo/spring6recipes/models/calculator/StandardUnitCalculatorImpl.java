package com.yogo.spring6recipes.models.calculator;

import org.springframework.stereotype.Service;

@Service
public class StandardUnitCalculatorImpl implements UnitCalculator {

	@Override
	public double kilogramToPound(double kilogram) {
		var pound = kilogram * 2.2;
		System.out.printf("%f kilogram = %f pound%n", kilogram, pound);
		return pound;
	}

	@Override
	public double kilometerToMile(double kilometer) {
		var mile = kilometer * 0.62;
		System.out.printf("%f kilometer = %f mile%n", kilometer, mile);
		return mile;
	}

}
