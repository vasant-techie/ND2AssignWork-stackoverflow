package com.nd2.assignwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nd2.assignwork.entity.TaskCategoryEntity;

public interface TaskCategoryRepository extends JpaRepository<TaskCategoryEntity, Integer> {

	// Find single TaskCategory by Category_Name
	TaskCategoryEntity findOneByCategoryName(String categoryName);
}
