package com.example.people.peopleexample.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

@Transactional
public interface PeopleRepository extends JpaRepository<People, Long> {

	public People findByEmail(String email);
}
