package org.kelvin.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


/**
 * 用于记录日志的方面组件
 *
 */
@Component
@Aspect
public class OperateLogger {

	/**
	 * 前置通知，后置通知，最终通知使用方法
	 */
	@Before("within(org.kelvin.controller..*)")
	public void log1() {
		//记录日志
		System.out.println("-->记录用户操作信息");
	}
	
	/**
	 * 环绕通知使用的方法
	 */
	@Around("within(org.kelvin.controller..*)")
	public Object log2(ProceedingJoinPoint p) throws Throwable {
		//目标组件的类名
		String className = p.getTarget().getClass().getName();
		
		//调用方法名
		String method = p.getSignature().getName();
		
		//当前系统时间
		String date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		
		//拼日志信息
		String msg = "-->用户在" + date + "，执行了" + className + "." + method + "()";
		
		//记录日志
		System.out.println(msg);
		
		//执行目标组件方法
		Object object = p.proceed();
		
		//在调用目标组件业务方法后也可以做一些业务处理
		System.out.println("-->调用目标组件业务方法后...");
		
		return object;
	}
	
	/**
	 * 异常通知使用的方法
	 */
	@AfterThrowing(pointcut="within(org.kelvin.controller..*)", throwing="exception")
	public void log3(Exception exception) {
		StackTraceElement[] element = exception.getStackTrace();
		//记录异常信息
		System.out.println("-->" + element[0].toString());
	}
}
