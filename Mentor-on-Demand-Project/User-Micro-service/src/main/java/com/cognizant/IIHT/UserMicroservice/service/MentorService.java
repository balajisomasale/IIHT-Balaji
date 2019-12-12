package com.cognizant.IIHT.UserMicroservice.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.IIHT.UserMicroservice.exception.LinkedInURLAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.exception.MentorSkillAlreadyExistsException;
import com.cognizant.IIHT.UserMicroservice.model.Mentor;
import com.cognizant.IIHT.UserMicroservice.model.Mentor_Skills;
import com.cognizant.IIHT.UserMicroservice.model.User;
import com.cognizant.IIHT.UserMicroservice.repository.MentorRepository;
import com.cognizant.IIHT.UserMicroservice.repository.MentorSkillRepository;
import com.cognizant.IIHT.UserMicroservice.repository.UserRepository;


@Service
public class MentorService {

	@Autowired
	private MentorRepository mentorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MentorSkillRepository mentorSkillRepository;

	@Transactional
	public void addMentor(@Valid Mentor mentor) throws LinkedInURLAlreadyExistsException {
		User user = userRepository.findByUserName(mentor.getUser().getUserName());
		mentor.setUser(user);
		if(mentorRepository.findByLinkedinURL(mentor.getLinkedinURL())!=null){
			throw new LinkedInURLAlreadyExistsException("This LinkedIn URL is already being used");
		}
		mentorRepository.save(mentor);
	}
	
	
	@Transactional
	public List<Mentor> getAllMentors()
	{
		return mentorRepository.getMentor();
	}
	
	@Transactional
	public List<Mentor_Skills> getAllMentorSkills()
	{
		return mentorSkillRepository.getMentorSkills();
	}
	
	@Transactional
	public void addMentorSkill(Mentor_Skills mentorSkill) throws MentorSkillAlreadyExistsException {
		
		Mentor mentor = mentorRepository.findByLinkedinURL(mentorSkill.getMentor().getLinkedinURL());
		
		mentorSkill.setMentor(mentor);
		List<Mentor_Skills> mentorExistingSkills = mentorSkillRepository.findAllByMentor(mentor);
		for(Mentor_Skills mentorExistingSkill:mentorExistingSkills){
			if(mentorExistingSkill.getSkill().getName().matches(mentorSkill.getSkill().getName())){
				throw new MentorSkillAlreadyExistsException("This skill exists for this mentor");
			}
		}
		mentorSkillRepository.save(mentorSkill);
	}
}
