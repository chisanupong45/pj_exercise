package com.cp.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.model.Exercise;
import com.cp.model.User;
import com.cp.model.dto.ExerciseDto;
import com.cp.repository.ExerciseRepository;
import com.cp.service.ExerciseService;
import com.cp.service.UserService;

import jakarta.validation.Valid;

@Service
public class ExerciseServiceImpl implements ExerciseService{

	@Autowired
	private ExerciseRepository exerciseRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Exercise> findByUserId(Integer id) {
		return this.exerciseRepository.findByUserId(id);
	}

	@Override
	public void save(ExerciseDto exerciseDto) {
		Exercise exercise = new Exercise();

		exercise.setExerciseType(exerciseDto.getExerciseType());
		exercise.setDuration(exerciseDto.getDuration());
		exercise.setCalories_burned(exerciseDto.getCalories_burned());
		exercise.setExercise_date(exerciseDto.getExercise_date());
		
		// ค้นหา User จาก userId
	    User user = userService.findById(exerciseDto.getUserId());

	    // ตั้งค่า User ให้กับ Exercise
	    exercise.setUser(user);

	    // บันทึก Exercise ลงในฐานข้อมูล
	    exerciseRepository.save(exercise);
		
	}

	@Override
	public void deleteById(Integer id) {
		this.exerciseRepository.deleteById(id);
		
	}

	@Override
	public Exercise findById(Integer id) {
		Optional<Exercise> optionalExercise = this.exerciseRepository.findById(id);
		if (optionalExercise.isPresent()) {
			return optionalExercise.get();
		} else {
			// Handle the case where the user is not found
			return null;
		}
	}
	
	@Override
	public void updateExercise(Integer id, @Valid Exercise exercise) {
		Optional<Exercise> optionalExercise = this.exerciseRepository.findById(id);
	    if (optionalExercise.isPresent()) {
	    	Exercise existingExercise = optionalExercise.get();
	        existingExercise.setExerciseType(exercise.getExerciseType());
	        existingExercise.setDuration(exercise.getDuration());
	        existingExercise.setCalories_burned(exercise.getCalories_burned());
	        existingExercise.setExercise_date(exercise.getExercise_date());
	        this.exerciseRepository.save(existingExercise);
	    } else {
	        // Handle the case where the user is not found
	    }
	}

}
