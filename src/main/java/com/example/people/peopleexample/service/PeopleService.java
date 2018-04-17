package com.example.people.peopleexample.service;

import java.util.List;

import com.example.people.peopleexample.data.People;

public interface PeopleService {

	public List<People> getPeople();
	public People createPeople(People people);
	public People getPeopleById(Long id);
	public People updatePeople(Long id, People people);
	public boolean deletePeople(Long id);
	
}
