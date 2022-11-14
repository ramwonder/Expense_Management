package com.Restexample.Restdemo.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.Restexample.Restdemo.Expense.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler /*extends ResponseEntityExceptionHandler */ {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ErrorObject> handleException(CustomException ex,WebRequest request)
	{
		ErrorObject errorObject =new ErrorObject();
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimeStamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodargException(MethodArgumentTypeMismatchException ex,WebRequest request)
	{
		ErrorObject errorObject =new ErrorObject();
		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimeStamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleInternalServerException(MethodArgumentTypeMismatchException ex,WebRequest request)
	{
		ErrorObject errorObject =new ErrorObject();
		errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimeStamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ItemAlreadyExistsException.class)
	public ResponseEntity<Object> handleItemExistsException(ItemAlreadyExistsException ex, WebRequest request) {
	ErrorObject eObject = new ErrorObject();
	eObject.setStatusCode(HttpStatus.CONFLICT.value());
	eObject.setMessage(ex.getMessage());
	eObject.setTimeStamp(new Date());
	return new ResponseEntity<Object>(eObject, HttpStatus.CONFLICT);
	}
	
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//	HttpHeaders headers, HttpStatus status, WebRequest request) {
//	Map<String, Object> body = new LinkedHashMap<>();
//	 body.put("timestamp", System.currentTimeMillis());
//	 body.put("statusCode", status.value()); 
//	 //Get all errors
//	 List<String> errors = ex.getBindingResult()
//	 .getFieldErrors()
//	 .stream()
//	 .map(x -> x.getDefaultMessage())
//	 .collect(Collectors.toList());
//	 body.put("errors", errors);
//	 return new ResponseEntity<Object>(body, status);
//	}
//	
}
