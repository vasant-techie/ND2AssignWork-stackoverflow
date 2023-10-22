package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.TaskCategoryDTO;

public interface ITaskCategoryService {

	// Save Task Category from DTO
	TaskCategoryDTO save(TaskCategoryDTO categoryDTO);
	// Delete Task Category
	void delete(int[] ids);
	// Get Task Category no paging
	List<TaskCategoryDTO> findAll();
}
