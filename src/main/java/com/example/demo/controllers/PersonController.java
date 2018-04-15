package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Person;
import com.example.demo.services.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping()
	public List<Person> getAll() {
		return personService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getOne(@PathVariable Long id) {
		Optional<Person> optional = personService.findOne(id);
		if (optional.isPresent()) {
			return new ResponseEntity<Person>(optional.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping()
	public Person save(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		personService.delete(id);
	}
}
