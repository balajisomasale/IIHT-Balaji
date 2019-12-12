package com.cognizant.IIHT.UserMicroservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.IIHT.UserMicroservice.exception.UserAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.model.User;
import com.cognizant.IIHT.UserMicroservice.repository.UserRepository;
import com.cognizant.IIHT.UserMicroservice.service.AppUserDetailsService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserMicroServiceApplication.class)
public class UserMicroServiceApplicationTests {

	@Autowired
	AppUserDetailsService userservice;
		
	@Test
	public void testUserSignup() throws UserAlreadyExistsException {
		
	
		User u =new User();
		
		u.setUserName("testUser");
		u.setPassword("pwd");
		u.setContactNumber("9100560867");
		u.setFirstName("asdasd");
		u.setLastName("asd");
		u.setRole("user");
	    assertEquals(userservice.signup(u),true);
		
	}


}
