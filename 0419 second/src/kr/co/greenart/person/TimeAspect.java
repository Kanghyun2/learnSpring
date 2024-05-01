package kr.co.greenart.person;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
	
	// 포인트컷 (어노테이션 + aspectj 문법)
//	@Pointcut("execution(public * kr.co.greenart.person.PersonRepository.*(..))")
	@Pointcut("@within(org.springframework.stereotype.Repository)")
	private void myPointcut() {}
	
	@Pointcut("execution(public * kr.co.greenart.person.PersonRepository.findPage(*,int))")
	private void printOffsetValue() {}
	
	@Before(value = "printOffsetValue() && args(*,offset)", argNames = "offset")
	public void printOffsetValueAspect(int offset) {
		System.out.println("offset: " + offset);
	}
	
	// 어드바이스(메소드, 작업 = 자바 코드)
//	@Before("myPointcut()")
//	public void printBefore() {
//		System.out.println("-- 메소드 호출 전 --");
//	}
//	@After("myPointcut()")
//	public void printAfter() {
//		System.out.println("-- 메소드 호출 후 --");
//	}
//	@AfterReturning(pointcut = "myPointcut()", returning = "returnValue")
//	public void printReturnValue(Object returnValue) {
//		System.out.println(returnValue);
//		((List)returnValue).clear();
//	}
//	@AfterThrowing
	
	@Around("execution(public * kr.co.greenart.person.PersonRepository.*(..))")
	public Object printTime(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		try {
			long startTime = System.currentTimeMillis();
			returnValue = joinPoint.proceed();
			long endTime = System.currentTimeMillis();
			
			System.out.println(endTime - startTime + "ms 만큼의 시간이 걸렸습니다.");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return returnValue;
	}
}






