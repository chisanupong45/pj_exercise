package com.cp.service;

import java.util.List;

import com.cp.model.Exercise;
import com.cp.model.dto.ExerciseDto;

import jakarta.validation.Valid;

public interface ExerciseService {
	
	List<Exercise> findByUserId(Integer id);
	
	void save(ExerciseDto exerciseDto);

	void deleteById(Integer id);

	Exercise findById(Integer id);

	void updateExercise(Integer id, @Valid Exercise exercise);
	
}
