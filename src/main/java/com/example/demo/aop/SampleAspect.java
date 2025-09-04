package com.example.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.example.demo.exception.SessionExpiredException;

import jakarta.servlet.http.HttpSession;

@Aspect
@Component
public class SampleAspect {

	public final HttpSession session;
	
	public SampleAspect (HttpSession session)
	{
		this.session = session;
	}
	
	
	
	@Before(
				"execution(* com.example.demo.controller.*.*(..))"
				+ "&& !execution(* com.example.demo.controller.LoginController.login(..))"
			)
	public void beforeAdvice(JoinPoint joinPoint)
	{
		if (session.getAttribute("user") == null)
		{
			System.out.println("로그인 하지 않은 유저의 부정 접속");
			throw new SessionExpiredException("session expired : " + session.getId());
			// 로그인 안되어 있음.
		}
		
		
//		System.out.println("=== Before Advice ===");
//		System.out.println(String.format("메서드:%s", joinPoint.getSignature().getName()));
	}
	
	
	@After("execution(* com.example.demo.controller.EmployeesController.*(..))")
	public void AftereAdvice(JoinPoint joinPoint)
	{
		System.out.println("=== After Advice ===");
	}
	
}