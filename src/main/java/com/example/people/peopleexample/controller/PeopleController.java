package com.example.people.peopleexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.people.peopleexample.data.People;
import com.example.people.peopleexample.error.PeopleException;
import com.example.people.peopleexample.service.PeopleService;

@RestController
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;

	
	  @GetMapping("/people")
	  public List<People> getPeople() {
		  return peopleService.getPeople();
	  }  
	  
	  @PostMapping("/people")
	  public People createPeople(@Valid @RequestBody People people) {
		  return peopleService.createPeople(people);
	  }
	  
	  @GetMapping("/people/{id}")
	  public People getPeopleById(@PathVariable(value="id") Long id) throws PeopleException {
		  People people= peopleService.getPeopleById(id);
		  if(people==null || people.getId()<=0) {
			  throw new PeopleException("The people id provided doesn't exist in the system");
		  }
		  return people;
	  }
	  
	  @PutMapping("/people/{id}")
	  public People updatePeople(@PathVariable(value="id") Long id, @Valid @RequestBody People people) throws PeopleException {
		  People updatedPeople= peopleService.updatePeople(id, people);
		  if(updatedPeople==null || updatedPeople.getId()<=0) {
			  throw new PeopleException("The people id can not be updated in the system");
		  }
		  return updatedPeople;
	  }
	  
	  @DeleteMapping("/people/{id}")
	  public ResponseEntity<?> deletePeople(@PathVariable(value="id") Long id) throws PeopleException {
		  boolean isDeleted = peopleService.deletePeople(id);
		  if(isDeleted) {
			  return ResponseEntity.ok().build();
		  }
		  else {
			  throw new PeopleException("The People id provided doesn't exist in the system and so it can not be deleted");
		  }
	  }
	  
}
