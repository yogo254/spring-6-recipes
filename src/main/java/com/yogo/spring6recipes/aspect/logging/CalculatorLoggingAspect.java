package com.yogo.spring6recipes.aspect.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorLoggingAspect {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("within(com.yogo.spring6recipes.models.calculator..*)")
	public void logBefore(JoinPoint joinPoint) {
		log.info("The method {} begins" + joinPoint.getSignature().getDeclaringTypeName());
	}

	@After("within(com.yogo.spring6recipes.models.calculator..*)")
	public void logAfter(JoinPoint joinPoint) {
		log.info("The method {} end ", joinPoint.getSignature().getDeclaringTypeName());
	}
}
