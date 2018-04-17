package com.example.people.peopleexample.error;

public class PeopleException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	
	public PeopleException() {
		super();
	}
	
	public PeopleException(String errorMessage) {
		this.setErrorMessage(errorMessage);
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
