package com.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.model.Person;

//this class is full of bad practices, do not try to learn anything from it!! Just for quick demo
@Repository
public class PersonJdbcRepository implements PersonRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Person findById(Long id) {
		// for demo only, do not do this in a real application!
		return jdbcTemplate.queryForObject("select * from Person where id=" + id, Person.class);
	}

	@Override
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from Person", (rs, rowNum) -> new Person(rs.getLong("id"),
				rs.getString("first_name"), rs.getString("last_name"), rs.getInt("age")));
	}

	@Override
	public Person savePerson(Person person) {
		jdbcTemplate.update("insert into Person(id, first_name, last_name, age) values ({}, {}, {}, {}",
				person.getId(), person.getFirstName(), person.getLastName(), person.getAge());
		return person;
	}

}
