package com.example.demo.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entities.BaseEntity;
import com.example.demo.websockets.WebSocketEvent;
import com.example.demo.websockets.WebSocketEventSender;

@Component
@Aspect
public class WebsocketUpdateAspect {
	
	@Autowired
	private WebSocketEventSender webSocketEventSender;
	
	
	@AfterReturning(pointcut = "com.example.demo.SystemArchitecture.ServiceSave()", 
			returning = "entity")
	public void sendUpdate(BaseEntity<Long> entity) {
		webSocketEventSender.sendEvent(new WebSocketEvent("update", entity.getType(), entity.getId()));
	}
	
	@AfterReturning(pointcut = "com.example.demo.SystemArchitecture.ServiceDelete()",
			returning = "entity")
	public void sendDeleteUpdate(BaseEntity<Long> entity) {
		webSocketEventSender.sendEvent(new WebSocketEvent("delete", entity.getType(), entity.getId()));
	}
}
