package com.cp.service;

import java.util.List;

import com.cp.model.Exercise;
import com.cp.model.dto.ExerciseDto;

public interface ExerciseService {
	
	List<Exercise> findByUserId(Integer id);
	
	void save(ExerciseDto exerciseDto);

	void deleteById(Integer id);
}
