package com.cp.model;

import jakarta.persistence.*;

@Entity
@Table(name =  "exercise")
public class Exercise {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "exercise_id")
	private Integer id;
	
	@Column(name = "exercise_type")
	private String exerciseType;
	
	private Integer duration;
	
	private Integer calories_burned;
	
	private String exercise_date;

	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
