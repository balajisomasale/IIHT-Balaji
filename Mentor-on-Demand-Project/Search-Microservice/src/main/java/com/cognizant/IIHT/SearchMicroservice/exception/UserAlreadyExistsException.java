package com.cognizant.IIHT.SearchMicroservice.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String string) {
		super("User already exists");
	}

}
