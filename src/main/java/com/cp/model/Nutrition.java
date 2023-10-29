package com.cp.model;

import jakarta.persistence.*;

@Entity
@Table(name =  "nutrition")
public class Nutrition {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "nutrition_id")
	private Integer id;
	
	@Column(name = "food_name")
	private String foodName;
	
	private Integer quantity;
	
	private Integer calories;
	
	private String nutrition_date;

	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="user_id")
    private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public String getNutrition_date() {
		return nutrition_date;
	}

	public void setNutrition_date(String nutrition_date) {
		this.nutrition_date = nutrition_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
