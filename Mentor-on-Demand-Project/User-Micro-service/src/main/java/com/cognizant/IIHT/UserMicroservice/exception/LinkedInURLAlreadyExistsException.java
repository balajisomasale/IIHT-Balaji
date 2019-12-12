package com.cognizant.IIHT.UserMicroservice.exception;
public class LinkedInURLAlreadyExistsException extends Exception {

	public LinkedInURLAlreadyExistsException(String message){
		super("This LinkedIn URL is already being used");
	}
}