package com.cognizant.IIHT.UserMicroservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.IIHT.UserMicroservice.exception.UserAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.model.User;
import com.cognizant.IIHT.UserMicroservice.repository.UserRepository;
import com.cognizant.IIHT.UserMicroservice.service.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {


	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserRepository userRepository;

	
	@GetMapping
	public List<User> getMenuItem() {

		return (userRepository.getUser());

	}
	
	@PostMapping
	public void signup(@RequestBody @Valid User newUser) throws UserAlreadyExistsException {
		appUserDetailsService.signup(newUser);
	}
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName)
	{
		return userRepository.findByUserName(userName);
	}
	
	

}
