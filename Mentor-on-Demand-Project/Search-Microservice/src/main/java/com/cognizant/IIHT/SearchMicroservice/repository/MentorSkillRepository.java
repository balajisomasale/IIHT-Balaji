package com.cognizant.IIHT.SearchMicroservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.IIHT.SearchMicroservice.model.Mentor;
import com.cognizant.IIHT.SearchMicroservice.model.Mentor_Skills;
import com.cognizant.IIHT.SearchMicroservice.model.Skill;



public interface MentorSkillRepository extends JpaRepository<Mentor_Skills, Long> {
	
//	List<Mentor_Skills> findAllByMentor(Mentor mentor);
//
//	@Query("From Mentor_Skills")
//	List<Mentor_Skills> getMentorSkills();
	 
	List<Mentor_Skills> findAllBySkill(Skill skill);
	
}