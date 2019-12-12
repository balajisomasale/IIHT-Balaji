package com.cognizant.IIHT.TrainingMicroservice.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String string) {
		super("User already exists");
	}

}
