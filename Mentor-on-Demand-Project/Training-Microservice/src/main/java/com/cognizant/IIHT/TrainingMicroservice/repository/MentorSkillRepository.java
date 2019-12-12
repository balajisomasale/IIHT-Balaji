package com.cognizant.IIHT.TrainingMicroservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.IIHT.TrainingMicroservice.model.Mentor;
import com.cognizant.IIHT.TrainingMicroservice.model.Mentor_Skills;


public interface MentorSkillRepository extends JpaRepository<Mentor_Skills, Long> {

	List<Mentor_Skills> findAllByMentor(Mentor mentor);
	

}
