package com.sid.tutorials.spring.module01.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CurrencyServiceAspect {
	@Pointcut("@annotation(com.sid.tutorials.spring.module01.annotations.InTransaction)")
	public void transactionAnnotationPointcut() {
	}

	@Pointcut("within(com.sid.tutorials.spring.module01.bls.*)")
	public void blsPackagePointcut() {
	}

	@Pointcut("@within(com.sid.tutorials.spring.module01.annotations.Secured)")
	public void securedClassPointcut() {
	}

	@Pointcut("execution(* com.sid.tutorials.spring.module01.bls.CurrencyService.getExchangeRate(..))")
	public void getExchangeRateMethodPointcut() {
	}

	@Pointcut("bean(currency_service)")
	public void namedBeanPointcut() {
	}

	@Pointcut("args(String, String, int)")
	public void stringsAndIntegerArgumentsMethodPointcut() {
	}

	@Pointcut("@args(com.sid.tutorials.spring.module01.annotations.Validated)")
	public void validatedArgumentPointcut() {
	}

	@Pointcut("target(com.sid.tutorials.spring.module01.bls.CurrencyService)")
	public void currencyServiceTargetPointcut() {
	}

	@Pointcut("@target(com.sid.tutorials.spring.module01.annotations.Secured)")
	public void currencyServiceSecuredTargetPointcut() {
	}

	@Pointcut("this(com.sid.tutorials.spring.module01.bls.CurrencyService)")
	public void currencyServiceThisPointcut() {
	}

	@Pointcut("blsPackagePointcut() && transactionAnnotationPointcut()")
	public void blsPackageAndInTransactionPointcut() {
	}

	@Before("transactionAnnotationPointcut()")
	public void beforeTransactionAnnotationAdvice() {
		System.out.println("Before - transactionAnnotationPointcut");
	}

	@Before("blsPackagePointcut()")
	public void beforeBlsPackageAdvice() {
		System.out.println("Before - blsPackagePointcut");
	}

	@Before("securedClassPointcut()")
	public void beforeSecuredClassAdvice() {
		System.out.println("Before - securedClassPointcut");
	}

	@Around("getExchangeRateMethodPointcut()")
	public Object aroundSecuredClassAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		try {
			System.out.println("Before - getExchangeRateMethodPointcut");
			return proceedingJoinPoint.proceed();
		} finally {
			System.out.println("After - getExchangeRateMethodPointcut");
		}
	}

	@After("namedBeanPointcut()")
	public void afterNamedBeanAdvice() {
		System.out.println("After - namedBeanPointcut");
	}

	@After("stringsAndIntegerArgumentsMethodPointcut()")
	public void afterStringsAndIntegerArgumentsMethodAdvice() {
		System.out.println("After - stringsAndIntegerArgumentsMethodPointcut");
	}

	/*
	 * @After("validatedArgumentPointcut()") public void
	 * afterValidatedArgumentAdvice() {
	 * System.out.println("After - validatedArgumentPointcut"); }
	 */

	/*
	 * @After("currencyServiceTargetPointcut()") public void
	 * afterCurrencyServiceTargetAdvice() {
	 * System.out.println("After - currencyServiceTargetPointcut"); }
	 */

	/*
	 * @After("currencyServiceSecuredTargetPointcut()") public void
	 * afterCurrencyServiceSecuredTargetAdvice() {
	 * System.out.println("After - currencyServiceSecuredTargetPointcut"); }
	 */

	@After("currencyServiceThisPointcut()")
	public void afterCurrencyServiceThisAdvice() {
		System.out.println("After - currencyServiceThisPointcut");
	}

	@After("blsPackageAndInTransactionPointcut()")
	public void afterBlsPackageAndInTransactionAdvice() {
		System.out.println("After - blsPackageAndInTransactionPointcut");
	}

	@AfterThrowing(value = "execution(* com.sid.tutorials.spring.module01.bls.CurrencyService.getCurrencyCountryName(..))", throwing = "exception")
	public void afterThrowingException(Exception exception) {
		System.out.println("Exception was thrown from getCurrencyCountryName: " + exception.getClass().getSimpleName());
	}

	@AfterReturning(value = "execution(* com.sid.tutorials.spring.module01.bls.CurrencyService.getCurrencyCountryName(..))", returning = "value")
	public void afterThrowingException(String value) {
		System.out.println("Value returned from getCurrencyCountryName: " + value);
	}

}
