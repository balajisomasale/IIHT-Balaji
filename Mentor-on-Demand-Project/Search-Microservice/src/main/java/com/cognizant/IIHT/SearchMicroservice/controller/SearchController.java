package com.cognizant.IIHT.SearchMicroservice.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.IIHT.SearchMicroservice.model.Mentor_Skills;
import com.cognizant.IIHT.SearchMicroservice.model.Skill;
import com.cognizant.IIHT.SearchMicroservice.service.SearchService;



@RestController
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@PostMapping("/mentorBySkill")
	public List<Mentor_Skills> searchMentorBySkill(@RequestBody @Valid Skill skill){
		return searchService.searchMentorBySkill(skill);
	}

}
