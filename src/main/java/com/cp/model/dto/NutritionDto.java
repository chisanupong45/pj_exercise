package com.cp.model.dto;

public class NutritionDto {
	
	private String foodName;
	private Integer quantity;
	private Integer calories;
	private String nutrition_date;
	private Integer userId;
	
	public NutritionDto() {
		super();
	}

	public NutritionDto(String foodName, Integer quantity, Integer calories, String nutrition_date, Integer userId) {
		super();
		this.foodName = foodName;
		this.quantity = quantity;
		this.calories = calories;
		this.nutrition_date = nutrition_date;
		this.userId = userId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
