package com.cognizant.IIHT.UserMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.IIHT.UserMicroservice.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserName(String username);
	
	
	
	@Query("From User")
	List<User> getUser();


}
