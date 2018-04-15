package com.example.demo.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.demo.entities.BaseEntity;

@Component
@Aspect
public class WebsocketUpdateAspect {
	
	@AfterReturning(pointcut = "com.example.demo.SystemArchitecture.ServiceSave()", 
			returning = "entity")
	public void sendUpdate(BaseEntity<Long> entity) {
		System.out.println("Save: " + entity.getType() + " id: " + entity.getId());
	}
	
	@AfterReturning(pointcut = "com.example.demo.SystemArchitecture.ServiceDelete()",
			returning = "entity")
	public void sendDeleteUpdate(BaseEntity<Long> entity) {
		System.out.println("Delete: " + entity.getType() + " id: " + entity.getId());		
	}
}
