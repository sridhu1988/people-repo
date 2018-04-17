package com.example.people.peopleexample.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.people.peopleexample.data.People;
import com.example.people.peopleexample.data.PeopleRepository;
import com.example.people.peopleexample.service.PeopleService;

@Service("peopleService")
public class PeopleServiceImpl implements PeopleService {

	@Autowired
	private PeopleRepository peopleRepository;
	
	@Override
	public List<People> getPeople() {
		return (List<People>) peopleRepository.findAll();
	}

	@Override
	public People createPeople(People people) {
		return peopleRepository.save(people);
	}

	@Override
	public People getPeopleById(Long id) {
		return peopleRepository.findById(id).orElse(null);
	}

	@Override
	public People updatePeople(Long id, People people) {
		Optional<People> peopleFromDB = peopleRepository.findById(id);
		  People updatedPeople = new People();
		  if(peopleFromDB.isPresent()) {
			  peopleFromDB.get().setName(people.getName());
			  peopleFromDB.get().setAge(people.getAge());
			  peopleFromDB.get().setDateOfBirth(people.getDateOfBirth());
			  peopleFromDB.get().setEmail(people.getEmail());
			  updatedPeople = peopleRepository.save(peopleFromDB.get());
		  }
		  return updatedPeople;
	}

	@Override
	public boolean deletePeople(Long id) {
		Optional<People> people = peopleRepository.findById(id);
		boolean isDeleted = false; 
		  if(people.isPresent()) {
			  peopleRepository.delete(people.get());
			  isDeleted=true;
		  }
		  else {
			  return isDeleted;
		  }
		  return isDeleted;
	}

}
