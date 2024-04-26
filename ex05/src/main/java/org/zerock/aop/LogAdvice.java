package org.zerock.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.log4j.Log4j;

@Aspect
@Log4j
@Component()
public class LogAdvice implements Advice{
	
	@Pointcut("execution(* org.zerock.service.*Impl.*(..)) ")
	public void allPointCut() {};
	
	@Pointcut("execution(* org.zerock.service.*Impl.modify*(..)) ")
	public void modifyPointCut() {};
	
//	@Before("modifyPointCut()")
//	public void logAdvice() {
//		log.info("Log Advice....................");
//	}
	
	@Around("modifyPointCut()")
	public Object logAdvice(ProceedingJoinPoint pjp) throws Throwable{
		log.info("Log Advice....................");
		
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		
		log.info(pjp.getClass().getName());
		log.info("소요 시간 : " + stopWatch.getTotalTimeMillis());
		
		return obj;
	}
	
	

	@Override
	public void advice() {
		log.info("Log4j Advice logAdvice........................");
	}

}
