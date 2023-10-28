package com.cp.model.dto;

public class ExerciseDto {

	private String exerciseType;
	private Integer duration;
	private Integer calories_burned;
	private String exercise_date;
	private Integer userId;
	
	public ExerciseDto() {
		super();
	}

	public ExerciseDto(String exerciseType, Integer duration, Integer calories_burned, String exercise_date,
			Integer userId) {
		super();
		this.exerciseType = exerciseType;
		this.duration = duration;
		this.calories_burned = calories_burned;
		this.exercise_date = exercise_date;
		this.userId = userId;
	}

	public String getExerciseType() {
		return exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getCalories_burned() {
		return calories_burned;
	}

	public void setCalories_burned(Integer calories_burned) {
		this.calories_burned = calories_burned;
	}

	public String getExercise_date() {
		return exercise_date;
	}

	public void setExercise_date(String exercise_date) {
		this.exercise_date = exercise_date;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
