package com.servidor.handler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.servidor.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.servidor.error.ExceptionDetails;
import java.util.Date;
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
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
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
	
	@ExceptionHandler(InvalidDataAccessApiUsageException.class)
	public ResponseEntity<?> handleInvalidDataAccessApiUsageException(Exception rfnException){
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
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> handleMethodArgumentTypeMismatchException(Exception rfnException){
		ExceptionDetails rfnDetails = ExceptionDetails.ExceptionDetailsBuilder 
			.newBuilder()
			.timestamp(new Date().getTime())
			.status(HttpStatus.BAD_REQUEST.value())
			.title("Invalid request")
			.detail(rfnException.getMessage())
			.developerMessage(rfnException.getClass().getName())
			.build();
		return new ResponseEntity<>(rfnDetails, HttpStatus.BAD_REQUEST);
}}
