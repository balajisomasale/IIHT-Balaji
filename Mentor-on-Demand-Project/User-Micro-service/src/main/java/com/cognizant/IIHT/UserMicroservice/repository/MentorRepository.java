package com.cognizant.IIHT.UserMicroservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.IIHT.UserMicroservice.model.Mentor;
import com.cognizant.IIHT.UserMicroservice.model.User;


public interface MentorRepository extends JpaRepository<Mentor, Long> {

//	Optional<Mentor> findByLinkedinURL(String linkedinURL);
	Mentor findByLinkedinURL(String linkedinURL);
	
	@Query("From Mentor")
	List<Mentor> getMentor();
}
