package com.cognizant.IIHT.TrainingMicroservice.service;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.IIHT.TrainingMicroservice.exception.EndDateCoincideException;
import com.cognizant.IIHT.TrainingMicroservice.exception.MentorSkillAlreadyExistsException;
import com.cognizant.IIHT.TrainingMicroservice.exception.StartDateCoincideException;
import com.cognizant.IIHT.TrainingMicroservice.model.Mentor;
import com.cognizant.IIHT.TrainingMicroservice.model.Mentor_Skills;
import com.cognizant.IIHT.TrainingMicroservice.model.Skill;
import com.cognizant.IIHT.TrainingMicroservice.model.Training;
import com.cognizant.IIHT.TrainingMicroservice.model.User;
import com.cognizant.IIHT.TrainingMicroservice.repository.MentorRepository;
import com.cognizant.IIHT.TrainingMicroservice.repository.MentorSkillRepository;
import com.cognizant.IIHT.TrainingMicroservice.repository.TrainingRepository;
import com.cognizant.IIHT.TrainingMicroservice.repository.UserRepository;


@Service
public class TrainingService {

	
	@Autowired
	private TrainingRepository trainingRepository;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MentorRepository mentorRepository;
	@Autowired
	private MentorSkillRepository mentorSkillRepository;
	
	public void addSkillLogin(@Valid Skill skill, String userName, float yearsExperience, float selfRating) throws MentorSkillAlreadyExistsException {
		User user = userRepository.findByUserName(userName).get();
		Mentor mentor = mentorRepository.findByUser(user);
		List<Mentor_Skills> mentorExistingSkills = mentorSkillRepository.findAllByMentor(mentor);
		for(Mentor_Skills mentorExistingSkill:mentorExistingSkills){
			if(mentorExistingSkill.getSkill().getName().matches(skill.getName())){
				throw new MentorSkillAlreadyExistsException("This skill exists for this mentor");
			}
		}
		Mentor_Skills mentorSkill = new Mentor_Skills();
		mentorSkill.setMentor(mentor);
		mentorSkill.setSelfRating(selfRating);
		mentorSkill.setYearsOfExperience(yearsExperience);
		mentorSkill.setSkill(skill);
		mentorSkillRepository.save(mentorSkill);
	}
	
	@Transactional
	public List<Training> getIncompleteTraining(String userName) {
		User user = userRepository.findByUserName(userName).get();
		Mentor mentor = mentorRepository.findByUser(user);
		List<Training> trainingList = trainingRepository.findAllByMentor(mentor);
		List<Training> pendingTrainingList = new ArrayList<Training>();
		for(Training training:trainingList){
			if(training.getStatus().equals("Request Pending")){
				pendingTrainingList.add(training);
			}
		}
		return pendingTrainingList;
	}
	
	
	public void addTrainingRequest(@Valid Training training) throws StartDateCoincideException, EndDateCoincideException {
		System.out.println(training);
		List<Training> trainingListMentor = trainingRepository.findAllByMentor(training.getMentor());
		System.out.println(training.getMentor());
		List<Training> trainingListUser = trainingRepository.findAllByUser(training.getUser());
		System.out.println(trainingListUser);
		for(Training existingTraining:trainingListMentor){
			if(existingTraining.getStatus().equals("Approved")){
				if(training.getStartDate().after(existingTraining.getStartDate()) || training.getStartDate().equals(existingTraining.getStartDate())){
					if(training.getStartDate().before(existingTraining.getEndDate()) || training.getStartDate().equals(existingTraining.getEndDate())){
						throw new StartDateCoincideException("Start Date Coincides with an existing approved training of Mentor");
					}
				}
				else if(training.getEndDate().after(existingTraining.getStartDate()) || training.getEndDate().equals(existingTraining.getStartDate())){
					if(training.getEndDate().before(existingTraining.getEndDate()) || training.getEndDate().equals(existingTraining.getEndDate())){
						throw new EndDateCoincideException("End Date Coincides with an existing approved training of Mentor");
					}
				}
			}
		}
		for(Training existingTraining:trainingListUser){
			if(existingTraining.getStatus().equals("Approved")){
				if(training.getStartDate().after(existingTraining.getStartDate()) || training.getStartDate().equals(existingTraining.getStartDate())){
					if(training.getStartDate().before(existingTraining.getEndDate()) || training.getStartDate().equals(existingTraining.getEndDate())){
						throw new StartDateCoincideException("Start Date Coincides with an existing approved training of User");
					}
				}
				else if(training.getEndDate().after(existingTraining.getStartDate()) || training.getEndDate().equals(existingTraining.getStartDate())){
					if(training.getEndDate().before(existingTraining.getEndDate()) || training.getEndDate().equals(existingTraining.getEndDate())){
						throw new EndDateCoincideException("End Date Coincides with an existing approved training of User");
					}
				}
			}
		}
		trainingRepository.save(training);
	}
	public void editStatus(@Valid Training training) {
		trainingRepository.save(training);
	}
	
}
