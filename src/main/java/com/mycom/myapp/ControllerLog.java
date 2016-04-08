package com.mycom.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerLog {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Pointcut("execution(* com.mycom.myapp.HomeController.*(..))")
	public void makeLog(){
		
	}
	
	@Around("makeLog()")
	public Object watchRequest(ProceedingJoinPoint joinpoint){
		Object returnval = null;
		try{
			logger.info("AOP Entry :" + joinpoint.getSignature());
			
			returnval = joinpoint.proceed();
			
		}catch (Throwable t){
			logger.info("AOP Leave in Exception :" + joinpoint.getSignature());
		}
		logger.info("AOP Leave :" + joinpoint.getSignature());
		return returnval;
	}
	
	/*@Before("makeLog()")
	public void entry(){
		logger.info("AOP Entry default GET!");
	}
	
	@AfterReturning("makeLog()")
	public void leave(){
		logger.info("AOP Leave default GET!");
	}*/
	
}
