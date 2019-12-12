package com.cognizant.IIHT.UserMicroservice.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String string) {
		super("User already exists");
	}

}
