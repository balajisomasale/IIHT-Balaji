package com.cognizant.IIHT.TrainingMicroservice.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.IIHT.TrainingMicroservice.model.User;



public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUserName(String userName);
	
	
	
	@Query("From User")
	List<User> getUser();


}
