package com.cognizant.IIHT.UserMicroservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.IIHT.UserMicroservice.exception.LinkedInURLAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.exception.MentorSkillAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.model.Mentor;
import com.cognizant.IIHT.UserMicroservice.model.Mentor_Skills;
import com.cognizant.IIHT.UserMicroservice.service.MentorService;



@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	private MentorService mentorService;
	
	@PostMapping("/addMentor")
	public void addMentor(@RequestBody @Valid Mentor mentor) throws LinkedInURLAlreadyExistsException{
		mentorService.addMentor(mentor);
	}
	
	@GetMapping("/mentors")
	public List<Mentor> getAllMentors()
	{
		return mentorService.getAllMentors();
	}
	
	@GetMapping("/mentorSkills")
	public List<Mentor_Skills> getAllMentorSkills()
	{
		return mentorService.getAllMentorSkills();
	}

	@PostMapping("/addMentorSkill")
	public void addMentorSkill(@RequestBody  Mentor_Skills mentorSkill) throws MentorSkillAlreadyExistsException {
		mentorService.addMentorSkill(mentorSkill);
	}
	
	
	
}