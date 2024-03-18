package com.prowings.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prowings.config.SpringConfiguration;
import com.prowings.service.Calculator;

public class TestAOP {
	
	public static void main(String[] args) throws InterruptedException {
		
		ApplicationContext cxt = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		Calculator calci = cxt.getBean(Calculator.class);
		
//		calci.addition(10L,20L);
		
		calci.sum(20,20);
	}

}
