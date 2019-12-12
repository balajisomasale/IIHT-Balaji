package com.cognizant.IIHT.UserMicroservice.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.IIHT.UserMicroservice.exception.UserAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.model.AppUser;
import com.cognizant.IIHT.UserMicroservice.model.User;
import com.cognizant.IIHT.UserMicroservice.repository.UserRepository;



@Service
public class AppUserDetailsService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsService.class);


	@Autowired
	UserRepository userrepository;



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Start");
        LOGGER.debug("UserRepository:{}", userrepository);
        User user = userrepository.findByUserName(username);
        LOGGER.debug("User:{}", user);

        if(user==null){
			throw new UsernameNotFoundException("User not found!");
		}
		else
		{
			LOGGER.info("user is:"+user);
			AppUser appUser = new AppUser(user);
			LOGGER.info("userDetails is: "+appUser);
			return appUser;
		}

	}

	public AppUserDetailsService(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	public boolean signup(@Valid User newuser) throws UserAlreadyExistsException{
        User newUser=userrepository.findByUserName(newuser.getUserName());
        if(newUser!=null)
        {
        	throw new UserAlreadyExistsException("Username is already taken");
        }
        else
        {
            String password=newuser.getPassword();
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
            String newpassword=encoder.encode(password);
            
            newuser.setPassword(newpassword);
            userrepository.save(newuser);
            return true;
        }
    
   }


}
