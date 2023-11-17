package com.servidor.handler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.servidor.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.servidor.error.ExceptionDetails;
import java.util.Date;
import org.springframework.dao.DataIntegrityViolationException;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(Exception rfnException){
		ExceptionDetails rfnDetails = ExceptionDetails.ExceptionDetailsBuilder 
			.newBuilder()
			.timestamp(new Date().getTime())
			.status(HttpStatus.NOT_FOUND.value())
			.title("Resource not found")
			.detail(rfnException.getMessage())
			.developerMessage(rfnException.getClass().getName())
			.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrityViolationException(Exception rfnException){
		ExceptionDetails rfnDetails = ExceptionDetails.ExceptionDetailsBuilder 
			.newBuilder()
			.timestamp(new Date().getTime())
			.status(HttpStatus.CONFLICT.value())
			.title("Data Integrity Violation")
			.detail(rfnException.getMessage())
			.developerMessage(rfnException.getClass().getName())
			.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleHttpRequestMethodNotSupportedException(Exception rfnException){
		ExceptionDetails rfnDetails = ExceptionDetails.ExceptionDetailsBuilder 
			.newBuilder()
			.timestamp(new Date().getTime())
			.status(HttpStatus.BAD_REQUEST.value())
			.title("Invalid request")
			.detail(rfnException.getMessage())
			.developerMessage(rfnException.getClass().getName())
			.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.BAD_REQUEST);
		
	}
	}
