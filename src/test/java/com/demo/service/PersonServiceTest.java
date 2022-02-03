package com.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.model.Person;
import com.demo.repository.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	PersonRepository personRepository;
	
	@InjectMocks
	PersonService testPersonService;
	
	@BeforeEach
	void setupMocks()
	{
		//this is the list that will be created by the Mock PersonRepository
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(1L, "Tom", "Sawyer", 15));
		persons.add(new Person(2L, "Huckleberry", "Finn", 10));

		//tell mockito that when findAll() is called on the Mock PersonRepository
		//it shall return the list above to the caller
		when(personRepository.findAll()).thenReturn(persons);
	}

	@Test
	void testAverageAge() {

		Double result = testPersonService.averageAge();
		assertEquals(12.5, result);
	}

	@Test
	void testFirstNames() {
		Set<String> firstNames = testPersonService.allFirstNames();
	
		assertEquals(2, firstNames.size());
		assertTrue(firstNames.contains("Huckleberry"));
		assertTrue(firstNames.contains("Tom"));

	}

	@Test
	void testLastNames() {
		//TODO as an exercise
	}

}
