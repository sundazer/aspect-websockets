package com.example.demo.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<K> {

	public abstract K getId();
}
