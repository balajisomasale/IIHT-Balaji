package com.cognizant.IIHT.UserMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.IIHT.UserMicroservice.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}