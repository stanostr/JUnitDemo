package com.demo.service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.model.Person;
import com.demo.repository.PersonRepository;

@Component
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Returns the average age of all persons in the database
	 * @return average age
	 */
	public Double averageAge() {
		List<Person> personList = personRepository.findAll();
		OptionalDouble avgAge = personList.stream().flatMapToInt(p -> IntStream.of(p.getAge())).average();
		if (avgAge.isPresent())
			return avgAge.getAsDouble();
		return 0D;
	}
	
	/**
	 * Returns a set of all first names for across all Persons in the database
	 * @return set of all first names
	 */
	public Set<String> allFirstNames()
	{
		List<Person> personList = personRepository.findAll();
		return personList.stream().map(m->m.getFirstName()).collect(Collectors.toSet());	
	}
	
	/**
	 * Returns a set of all last names for across all Persons in the database
	 * @return set of all last names
	 */
	public Set<String> allLastNames()
	{
		List<Person> personList = personRepository.findAll();
		return personList.stream().map(m->m.getLastName()).collect(Collectors.toSet());	
	}
	
	/**
	 * to add new persons to database
	 */
	public Person savePerson(Person person)
	{
		return personRepository.savePerson(person);
	}
}
