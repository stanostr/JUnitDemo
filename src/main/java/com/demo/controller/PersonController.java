package com.demo.controller;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Person;
import com.demo.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/avg-age")
	public Set<Double> averageAge()
	{
		return Collections.singleton(personService.averageAge());
	}
	
	@GetMapping("/last-names")
	public Set<String> lastNames()
	{
		return personService.allLastNames();
	}
	
	@GetMapping("/first-names")
	public Set<String> firstNames()
	{
		return personService.allFirstNames();
	}
	
	@PostMapping("/save")
	public Person savePerson(Person person)
	{
		return personService.savePerson(person);
	}
}
