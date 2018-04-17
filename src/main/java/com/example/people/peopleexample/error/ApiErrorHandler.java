package com.example.people.peopleexample.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApiErrorHandler {

	   private int statusCode;
	   private HttpStatus httpStatus;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String errorMessage;
	   private String debugMessage;

	   private ApiErrorHandler() {
	       timestamp = LocalDateTime.now();
	   }

	   public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDebugMessage() {
		return debugMessage;
	}

	public void setDebugMessage(String debugMessage) {
		this.debugMessage = debugMessage;
	}

	public ApiErrorHandler(HttpStatus httpStatus) {
	       this();
	       this.httpStatus = httpStatus;
	   }

	   public ApiErrorHandler(HttpStatus httpStatus, Throwable ex) {
	       this();
	       this.httpStatus = httpStatus;
	       this.errorMessage = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   public ApiErrorHandler(int statusCode,HttpStatus httpStatus, String errorMessage, Throwable ex) {
	       this();
	       this.statusCode = statusCode;
	       this.httpStatus = httpStatus;
	       this.errorMessage = errorMessage;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	   
	   public ApiErrorHandler(int statusCode,HttpStatus httpStatus, String errorMessage, String debugMessage) {
	       this();
	       this.statusCode = statusCode;
	       this.httpStatus = httpStatus;
	       this.errorMessage = errorMessage;
	       this.debugMessage = debugMessage;
	   }

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	}
