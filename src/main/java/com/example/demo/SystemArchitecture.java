package com.example.demo;

import org.aspectj.lang.annotation.Pointcut;

public class SystemArchitecture {

	@Pointcut("execution(* com.example.demo.services.*.save(..))")
	public void ServiceSave() {}
	
	@Pointcut("execution(* com.example.demo.services.*.delete(..))")
	public void ServiceDelete() {}
}
