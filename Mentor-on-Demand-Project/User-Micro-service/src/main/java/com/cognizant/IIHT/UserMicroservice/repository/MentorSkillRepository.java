package com.cognizant.IIHT.UserMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.IIHT.UserMicroservice.model.Mentor;
import com.cognizant.IIHT.UserMicroservice.model.Mentor_Skills;



public interface MentorSkillRepository extends JpaRepository<Mentor_Skills, Long> {
	
	List<Mentor_Skills> findAllByMentor(Mentor mentor);

	@Query("From Mentor_Skills")
	List<Mentor_Skills> getMentorSkills();
	 
	
}