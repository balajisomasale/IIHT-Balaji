package com.cognizant.IIHT.UserMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.IIHT.UserMicroservice.model.Skill;
import com.cognizant.IIHT.UserMicroservice.service.SkillService;



@RestController

public class SkillController {


	@Autowired
	private SkillService skillService;
	
	@GetMapping("/skills")
	public List<Skill> getAllSkills() {
		return skillService.getAllSkills();
	}
}
