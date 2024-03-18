package com.prowings.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public void print()
	{
		System.out.println("Inside Print method");
	}
	
	public void addition(int a,int b)
	{
		System.out.println("inside addition (int int) method !!");
		System.out.println("Addition is : "+ (a + b));
		System.out.println("====================================");
	}
	
	public void addition(long a,long b)
	{
		System.out.println("inside addition (long long) method !!");
		System.out.println("Addition is : "+ (a + b));
		System.out.println("====================================");
//		throw new ArithmeticException();
	}
	
	public Integer sum(int a,int b) throws InterruptedException
	{
		System.out.println("Inside Sum method !");
		
		Thread.sleep(5000);
		System.out.println("====================================");
		return a+b;
	}
	
	
}
