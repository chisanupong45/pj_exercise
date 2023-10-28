package com.cp.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.model.Nutrition;
import com.cp.model.User;
import com.cp.model.dto.NutritionDto;
import com.cp.repository.NutritionRepository;
import com.cp.service.NutritionService;
import com.cp.service.UserService;

import jakarta.validation.Valid;

@Service
public class NutritionServiceImpl implements NutritionService{

	@Autowired
	private NutritionRepository nutritionRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Nutrition> findByUserId(Integer id) {
		return this.nutritionRepository.findByUserId(id);
	}

	@Override
	public void save(NutritionDto nutritionDto) {
		Nutrition nutrition = new Nutrition();

	    nutrition.setFoodName(nutritionDto.getFoodName());
	    nutrition.setQuantity(nutritionDto.getQuantity());
	    nutrition.setCalories(nutritionDto.getCalories());
	    nutrition.setNutrition_date(nutritionDto.getNutrition_date());
		
	 // ค้นหา User จาก userId
	    User user = userService.findById(nutritionDto.getUserId());

	    // ตั้งค่า User ให้กับ Nutrition
	    nutrition.setUser(user);

	    // บันทึก Nutrition ลงในฐานข้อมูล
	    nutritionRepository.save(nutrition);
	}

	@Override
	public void deleteNutrition(Integer id) {
		this.nutritionRepository.deleteById(id);
	}

	@Override
	public Nutrition findById(Integer id) {
		Optional<Nutrition> optionalNutrition = this.nutritionRepository.findById(id);
		if (optionalNutrition.isPresent()) {
			return optionalNutrition.get();
		} else {
			// Handle the case where the user is not found
			return null;
		}
	}

	@Override
	public void updateNutrition(Integer id, @Valid Nutrition nutrition) {
		Optional<Nutrition> optionalNutrition = this.nutritionRepository.findById(id);
	    if (optionalNutrition.isPresent()) {
	        Nutrition existingNutrition = optionalNutrition.get();
	        existingNutrition.setFoodName(nutrition.getFoodName());
	        existingNutrition.setCalories(nutrition.getCalories());
	        existingNutrition.setQuantity(nutrition.getQuantity());
	        existingNutrition.setNutrition_date(nutrition.getNutrition_date());
	        this.nutritionRepository.save(existingNutrition);
	    } else {
	        // Handle the case where the user is not found
	    }
	}

}
