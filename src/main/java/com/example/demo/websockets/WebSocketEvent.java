package com.example.demo.websockets;

public class WebSocketEvent {

	private String entityType;
	private String action;
	private Long id;
		
	public WebSocketEvent(String action, String entityType, Long id) {
		super();
		this.action = action;
		this.entityType = entityType;
		this.id = id;
	}
	
	public String getEntity() {
		return entityType;
	}
	public void setEntity(String entity) {
		this.entityType = entity;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
}
