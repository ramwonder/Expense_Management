package com.Restexample.Restdemo.Exception;

public class ItemAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	public ItemAlreadyExistsException(String message) {
	 super(message);
	}
}
