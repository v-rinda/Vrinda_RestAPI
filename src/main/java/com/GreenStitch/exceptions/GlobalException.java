package com.GreenStitch.exceptions;

import java.time.LocalDateTime;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<Error> globalExceptionHandler(UserException userException , WebRequest request)
	{
		Error error  = new Error();
		error.setDescription(request.getDescription(false));
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(userException.getMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> globalExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException)
	{
		Error error  = new Error();
		error.setDescription("Error Found!!");
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(methodArgumentNotValidException.getFieldError().getDefaultMessage());

		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
