package com.alphaware.blogapplication.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(ResourceNotFoundException ie, WebRequest req)  {
			ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(MethodArgumentNotValidException ie, WebRequest req)  {	
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));
	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> myExpHandler(ConstraintViolationException ie, WebRequest req)  {
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));

	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> myanyExphandler(Exception ie, WebRequest req)  {
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), ie.getMessage(), req.getDescription(false));

	 return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe,WebRequest req)  {				
		ErrorDetails err=new ErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
						
	}
	
}
