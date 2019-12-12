package com.cognizant.IIHT.TrainingMicroservice.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.IIHT.TrainingMicroservice.model.Mentor;
import com.cognizant.IIHT.TrainingMicroservice.model.Training;
import com.cognizant.IIHT.TrainingMicroservice.model.User;

public interface TrainingRepository extends JpaRepository<Training, Long> {

	List<Training> findAllByMentor(Mentor mentor);

	List<Training> findAllByUser(User user);

}
