package com.birthday.Reminder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.birthday.Reminder.model.Person;
import com.birthday.Reminder.repository.PersonRepository;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	
	@PostMapping("/person")
	public Person addPerson(@RequestBody Person person) {
		return personRepository.save(person);
		
	}
	@GetMapping("/all")
	public ResponseEntity<List<Person>> getAllPersons() {

		return (ResponseEntity.ok( personRepository.findAll()));
	}
	
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable(value="id") Integer id) {

		return ResponseEntity.ok().body( personRepository.findById(id).orElseThrow());
	}
	
	@GetMapping("/test")
	public String testResponse() {

		return "Response Hard Coded!";
	}
	
	

	@GetMapping("/test/{name}")
	public String testResponseForPath(@PathVariable("name") String pathName) {

		return String.format("%s%s", "Response from path param ",pathName);
				
	}
	

}
