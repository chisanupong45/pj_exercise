package com.cp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.model.Nutrition;

@Repository
public interface NutritionRepository extends JpaRepository<Nutrition, Integer> {
	List<Nutrition> findByUserId(Integer id);
 
}

