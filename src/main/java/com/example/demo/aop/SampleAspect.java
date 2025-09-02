package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

	
	@Before("execution(* com.example.demo.controller.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint)
	{
		System.out.println("=== Before Advice ===");
		System.out.println(String.format("메서드:%s", joinPoint.getSignature().getName()));
	}
	
	
	@After("execution(* com.example.demo.controller.EmployeesController.*(..))")
	public void AftereAdvice(JoinPoint joinPoint)
	{
		System.out.println("=== After Advice ===");
	}
	
}