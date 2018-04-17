package com.example.people.peopleexample.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class People {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	@NotNull
	private int age;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date dateOfBirth;
	@NotNull
	private String email;
	
	public People() {
		super();
	}
	
	public People(long id) { 
	    this.id = id;
	  }
	
	public People(Long id,String name, int age, Date dateOfBirth, String email) {
		super();
		this.id=id;
		this.name=name;
		this.age=age;
		this.dateOfBirth=dateOfBirth;
		this.email=email;
	}
	
	public People(String name, int age, Date dateOfBirth, String email) {
		super();
		this.name=name;
		this.age=age;
		this.dateOfBirth=dateOfBirth;
		this.email=email;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
