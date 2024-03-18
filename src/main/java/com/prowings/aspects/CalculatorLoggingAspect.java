package com.prowings.aspects;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class CalculatorLoggingAspect {
	
	@Before("execution(* com.prowings.service.Calculator.addition(int,int))")
	public void logBeforeAddition(JoinPoint joinPoint)
	{
		System.out.println("logBefore addition() is running !");
		System.out.println("Hijacked :"+ joinPoint.getSignature().getName());
		System.out.println("==================================");
	}
	
	@AfterReturning("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void logAfterReturningAddition(JoinPoint joinPoint)
	{
		System.out.println("logAfterReturning addition() is running !");
		System.out.println("Hijacked :"+ joinPoint.getSignature().getName());
		System.out.println("==================================");
	}
	
	@AfterThrowing("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void logAfterThrowingAddition(JoinPoint joinPoint)
	{
		System.out.println("logAfterThrowing addition() is running !!");
		System.out.println("Hijacked :"+ joinPoint.getSignature().getName());
		System.out.println("==================================");
	}
	
	@After("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void logAfterAddition(JoinPoint joinPoint)
	{
		System.out.println("logAfter addition() is running !!");
		System.out.println("Hijacked :"+ joinPoint.getSignature().getName());
		System.out.println("==================================");
	}
	
	@Around("execution(* com.prowings.service.Calculator.sum(int,int))")
	public void logAroundSum(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("==LoggingAspect.logAroundMethod() - Before method call==");
		
		long start = System.nanoTime();
		
		Object result = pjp.proceed();
		Integer res =  (Integer) result;
//		int  r = res;
		
		System.out.println("Method returned value -->>>  "+ res);
		long end = System.nanoTime();
		
		String methodName = pjp.getSignature().getName();
		
		System.out.println("Excecution of "+ methodName + " took " + TimeUnit.NANOSECONDS.toMicros(end - start)+ " ms ");
		
		System.out.println("==LoggingAspect.logAroundMethod() -After method call==");
		
		
		
	}

	
}
