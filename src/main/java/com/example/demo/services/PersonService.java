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
	
	public Person findOne(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.orElseThrow(IllegalArgumentException::new);
	}
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public Person delete(Long id) {
		Optional<Person> person = personRepository.findById(id);
		person.ifPresent(personRepository::delete);
		return person.orElseThrow(IllegalArgumentException::new);
	}
}
