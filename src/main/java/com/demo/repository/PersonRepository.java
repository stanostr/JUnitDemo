package com.demo.repository;

import java.util.List;

import com.demo.model.Person;

public interface PersonRepository {

	/**
	 * Returns a person with the given id
	 * @param id
	 * @return the person with given id
	 */
	Person findById(Long id);

	/**
	 * Returns all person in the database
	 * @return list of all persons
	 */
	List<Person> findAll();

	/**
	 * Saves a person to database and then returns value that was saved
	 * @param person to be saved
	 * @return the person that was saved 
	 */
	Person savePerson(Person person);
}
