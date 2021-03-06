package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "people")
public class Person extends BaseEntity<Long> {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}
	
	@Transient
	@JsonIgnore
	public String getType() {
		return getClass().getAnnotation(Entity.class).name();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
