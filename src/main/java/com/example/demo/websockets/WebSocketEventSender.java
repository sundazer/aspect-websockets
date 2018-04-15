package com.example.demo.websockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class WebSocketEventSender {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	public void sendEvent(String action, String entity, Long id) {
		this.sendEvent(new WebSocketEvent(action, entity, id));
	}

	@MessageMapping("/updates")
	public void sendEvent(WebSocketEvent event) {
		messagingTemplate.convertAndSend("/topic/updates", event);
	}

}
