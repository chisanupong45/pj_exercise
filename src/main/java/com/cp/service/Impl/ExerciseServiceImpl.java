package com.cp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.model.Exercise;
import com.cp.model.Nutrition;
import com.cp.model.User;
import com.cp.model.dto.ExerciseDto;
import com.cp.repository.ExerciseRepository;
import com.cp.service.ExerciseService;
import com.cp.service.UserService;

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

}
