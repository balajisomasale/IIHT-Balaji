package com.cognizant.IIHT.TrainingMicroservice.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.IIHT.TrainingMicroservice.exception.EndDateCoincideException;
import com.cognizant.IIHT.TrainingMicroservice.exception.MentorSkillAlreadyExistsException;
import com.cognizant.IIHT.TrainingMicroservice.exception.StartDateCoincideException;
import com.cognizant.IIHT.TrainingMicroservice.model.Skill;
import com.cognizant.IIHT.TrainingMicroservice.model.Training;
import com.cognizant.IIHT.TrainingMicroservice.repository.UserRepository;
import com.cognizant.IIHT.TrainingMicroservice.service.TrainingService;



@RestController
public class TrainingController {

	@Autowired
	private TrainingService trainingService;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/addTrainingRequest")
	public void addTrainingRequest(@RequestBody @Valid Training training) throws StartDateCoincideException, EndDateCoincideException {
		trainingService.addTrainingRequest(training);
	}
	@GetMapping("/getIncompleteTraining/{userName}")
	public List<Training> getIncompleteTraining(@PathVariable String userName) {
		return trainingService.getIncompleteTraining(userName);
	}
	
	@PostMapping("/editStatus")
	public void editStatus(@RequestBody @Valid Training training){
		trainingService.editStatus(training);
	}
	
	@PostMapping("/addSkillLogin/{userName}/{yearsExperience}/{selfRating}")
	public void addSkillLogin(@RequestBody @Valid Skill skill, @PathVariable String userName, @PathVariable float yearsExperience, @PathVariable float selfRating) throws MentorSkillAlreadyExistsException{
		trainingService.addSkillLogin(skill,userName,yearsExperience,selfRating);
	}
	


}
