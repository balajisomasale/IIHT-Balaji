package com.cognizant.IIHT.TrainingMicroservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.IIHT.TrainingMicroservice.model.Mentor;
import com.cognizant.IIHT.TrainingMicroservice.model.User;


public interface MentorRepository extends JpaRepository<Mentor, Long> {

	Mentor findByUser(User user);

}
