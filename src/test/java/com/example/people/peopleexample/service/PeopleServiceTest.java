package com.example.people.peopleexample.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.people.peopleexample.data.People;
import com.example.people.peopleexample.data.PeopleRepository;
import com.example.people.peopleexample.service.impl.PeopleServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class PeopleServiceTest {

	@Mock
	private PeopleRepository peopleRepository;
	
	@InjectMocks
	private PeopleServiceImpl peopleService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetPeople(){
		List<People> peopleList = new ArrayList<People>();
		peopleList.add(new People("testone",29,new Date(12/12/1988),"testemail@email.com"));
		peopleList.add(new People("testtwo",29,new Date(12/11/1988),"testtwoemail@email.com"));
		when(peopleRepository.findAll()).thenReturn(peopleList);
		
		List<People> result = peopleService.getPeople();
		assertEquals(2, result.size());
	}
	
	@Test
	public void testcreatePeople(){
		People people = new People("testuser",29,new Date(11/11/1988),"a@ex.com");
		when(peopleRepository.save(people)).thenReturn(people);
		People result = peopleService.createPeople(people);
		assertEquals("testuser", result.getName());
		assertEquals(29, result.getAge());
	}
}
