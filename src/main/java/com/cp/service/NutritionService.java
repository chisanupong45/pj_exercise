package com.cp.service;

import java.util.List;

import com.cp.model.Nutrition;
import com.cp.model.dto.NutritionDto;

public interface NutritionService {
	
	List<Nutrition> findByUserId(Integer id);

	void save(NutritionDto nutritionDto);

	void deleteNutrition(Integer id);

}
