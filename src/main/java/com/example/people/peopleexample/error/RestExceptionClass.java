package com.example.people.peopleexample.error;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionClass extends ResponseEntityExceptionHandler {

   @Override
   protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       String error = "The provided entity is invalid because of null or malformed attributes";
       return buildResponseEntity(new ApiErrorHandler(422,HttpStatus.UNPROCESSABLE_ENTITY, error, ex));
   }
   
   @ExceptionHandler(PeopleException.class)
   public ResponseEntity<Object> peopleExceptionHandler(PeopleException ex){
	   String error = "The requested entity is invalid because it does not exist in the system";
	   return buildResponseEntity(new ApiErrorHandler(400,HttpStatus.BAD_REQUEST, error, ex.getErrorMessage()));
   }
   
   private ResponseEntity<Object> buildResponseEntity(ApiErrorHandler apiErrorHandler) {
       return new ResponseEntity<>(apiErrorHandler, apiErrorHandler.getHttpStatus());
   }
   
}