package com.demo.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.demo.model.Person;

public class PersonTest {

	@Test
	void testPersonSettersAndGetters()
	{
		Long id = 1L;
		String firstName = "Carl";
		String lastName = "Jung";
		int age = 20;
		
		Person testPerson = new Person();
		testPerson.setId(id);
		testPerson.setFirstName(firstName);
		testPerson.setLastName(lastName);
		testPerson.setAge(age);
		
		assertEquals(id, testPerson.getId());
		assertEquals(firstName, testPerson.getFirstName());
		assertEquals(lastName, testPerson.getLastName());
		assertEquals(age, testPerson.getAge());

		assertNotNull(testPerson.toString());
	}
}
