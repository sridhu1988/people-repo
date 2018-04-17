package com.example.people.peopleexample;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PeopleExampleApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	public HttpStatus status;
	
	@Test
	public void verifyAllPeopleList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/people").accept(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$", hasSize(5))).andDo(print());
	}
	
	@Test
	public void verifyPeopleById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/people/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.name").exists())
		.andExpect(jsonPath("$.age").exists())
		.andExpect(jsonPath("$.id").value(3))
		.andExpect(jsonPath("$.name").value("user3"))
		.andExpect(jsonPath("$.age").value(29))
		.andExpect(jsonPath("$.dateOfBirth").value("11/13/1988"))
		.andExpect(jsonPath("$.email").value("user3@axp.com"))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidPeopleId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/people/0").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.statusCode").value(400))
		.andExpect(jsonPath("$.httpStatus").value("BAD_REQUEST"))
		.andExpect(jsonPath("$.errorMessage").value("The requested entity is invalid because it does not exist in the system"))
		.andExpect(jsonPath("$.debugMessage").value("The people id provided doesn't exist in the system"))
		.andDo(print());
	}
	
	@Test
	public void verifyInvalidPeopleDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/people/16").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.statusCode").value(400))
		.andExpect(jsonPath("$.httpStatus").value("BAD_REQUEST"))
		.andExpect(jsonPath("$.errorMessage").value("The requested entity is invalid because it does not exist in the system"))
		.andExpect(jsonPath("$.debugMessage").value("The People id provided doesn't exist in the system and so it can not be deleted"))
		.andDo(print());
	}
	
	@Test
	public void verifyPostPeople() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/people").contentType(MediaType.APPLICATION_JSON)
        .content("{ \"name\": \"test1\", \"age\" : \"aa\", \"dateOfBirth\" : \"12/12/1988\", \"email\" : \"test@axp.com\" }")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.statusCode").value(422))
		.andExpect(jsonPath("$.httpStatus").value("UNPROCESSABLE_ENTITY"))
		.andExpect(jsonPath("$.errorMessage").value("The provided entity is invalid because of null or malformed attributes"))
		.andDo(print());
	}

}
