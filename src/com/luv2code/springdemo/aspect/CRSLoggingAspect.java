package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRSLoggingAspect {

	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
		
	// setup pointcut declarations
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {};
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {};
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {};
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {};
	
	// add @Before advice
//	@Before("forAppFlow()")
//	public void before(JoinPoint theJoinPoint) {
//		
//		// display method we are calling
//		String theMethod = theJoinPoint.getSignature().toShortString();
//		myLogger.info("===========>> in @Before: calling method:" + theMethod);
//		
//		// display the arguments to the method
//		
//		
//		// get the arguments
//		Object[] args = theJoinPoint.getArgs();
//		
//		// loop thru and dissplay args
//		for (Object tempArg : args) {
//			myLogger.info("===========>> argument: " + tempArg);
//		}
//		
//	}
//	
//	// add @AfterReturning advice
//	@AfterReturning(
//			pointcut="forAppFlow()",
//			returning="theResult")
//	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
//		
//		// display method we are returning from
//		String theMethod = theJoinPoint.getSignature().toShortString();
//		myLogger.info("===========>> in @AfterReturning: from method:" + theMethod);
//		
//		// diplay data returned
//		myLogger.info("===========>> result: " + theResult);
//	}
	
	// add @Around advice
	@Around("forAppFlow()")
	public Object around(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("===========>> in Executing @Around on method　before 'proceed': " + method);
		
		// now, let's execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());

			// rethro exception
			throw e;			
		}

		myLogger.info("===========>> in Executing @Around on method　after 'proceed': " + method);
		myLogger.info("===========>> result: " + result);
		
		return result;
		
	}
}
