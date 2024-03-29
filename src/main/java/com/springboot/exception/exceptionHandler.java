package com.springboot.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.UnexpectedTypeException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class exceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String,String> handleInvalidException(MethodArgumentNotValidException e)
	{
		
		Map<String,String> errorMap=new HashMap<>();
		
		e.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		return errorMap;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ResourceNotFoundException.class)
	public Map<String,String> handleBusinessException(ResourceNotFoundException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessge", ex.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnexpectedTypeException.class)
	public Map<String,String> handleDobException(UnexpectedTypeException ex)
	{
		Map<String,String> errorMap=new HashMap<>();
		errorMap.put("errorMessge", ex.getMessage());
		return errorMap;
	}
}
