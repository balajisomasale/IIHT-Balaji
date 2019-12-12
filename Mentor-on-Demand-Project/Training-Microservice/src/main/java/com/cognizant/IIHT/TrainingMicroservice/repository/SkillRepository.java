package com.cognizant.IIHT.TrainingMicroservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.IIHT.TrainingMicroservice.model.Skill;


public interface SkillRepository extends JpaRepository<Skill, Long> {

}
