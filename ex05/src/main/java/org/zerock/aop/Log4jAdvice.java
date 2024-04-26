package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component()
public class Log4jAdvice implements Advice{
	
	@Pointcut("execution(* org.zerock.service.*Impl.*(..)) ")
	public void allPointCut() {};
	
	
	@Around("allPointCut()")
	public Object log4jAdvice(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info(pjp.getSignature().getName() + "Log4j Advice...................");
		
		Object obj = pjp.proceed();
		
		return obj;
	}
	

	@Override
	public void advice() {
		log.info("Log4j Advice log4jAdvice........................");
	}

}
