package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		List<Person> people = new ArrayList<>();
		personRepository.findAll().forEach(people::add);
		return people;
	}
	
	public Optional<Person> findOne(Long id) {
		return personRepository.findById(id);
	}
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public void delete(Long id) {
		personRepository.deleteById(id);
	}
}
