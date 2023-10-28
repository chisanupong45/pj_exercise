package com.cp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
	List<Exercise> findByUserId(Integer id);
 
}

