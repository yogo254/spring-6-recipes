package com.yogo.spring6recipes.aspect.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	@AfterReturning("within(com.yogo.spring6recipes.models.calculator..*)")
	public void logAfterReturning(JoinPoint joinPoint) {
		log.info("The method {} return ", joinPoint.getSignature().getDeclaringTypeName());
	}

	@AfterThrowing("within(com.yogo.spring6recipes.models.calculator..*)")
	public void logAfterThrowing(JoinPoint joinPoint) {
		log.info("The method {} threw exception ", joinPoint.getSignature().getDeclaringTypeName());
	}

	@Around("within(com.yogo.spring6recipes.models.calculator..*)")
	public Object logAroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
		var name = joinPoint.getSignature().getName();
		var args = Arrays.toString(joinPoint.getArgs());
		log.info("The method {}() begins with {}.", name, args);
		try {
			var result = joinPoint.proceed();
			log.info("The method {}() ends with {}.", name, result);
			return result;
		} catch (IllegalArgumentException ex) {
			log.error("Illegal argument {} in {}()", args, name);
			throw ex;
		}
	}

}
