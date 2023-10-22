package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.TaskCategoryDTO;
import com.nd2.assignwork.entity.TaskCategoryEntity;

@Component
public class TaskCategoryConverter {

	// Convert from DTO to Entity
	public TaskCategoryEntity toEntity(TaskCategoryDTO dto) {
		TaskCategoryEntity entity = new TaskCategoryEntity();
		entity.setCategoryName(dto.getCategoryName());
		return entity;
	}
	
	// Convert from Entity to DTO
	public TaskCategoryDTO toDTO(TaskCategoryEntity entity) {
		TaskCategoryDTO dto = new TaskCategoryDTO();
		if(entity.getTaskCategoryID() != null) {
			dto.setTaskCategoryID(entity.getTaskCategoryID());
		}
		dto.setCategoryName(entity.getCategoryName());
		return dto;
	}
	
	// Save update TaskCategory by convert from DTO to Entity
	public TaskCategoryEntity toEntity(TaskCategoryDTO dto, TaskCategoryEntity entity) {
		if(dto.getCategoryName() != null) {
			entity.setCategoryName(dto.getCategoryName());
		}
		return entity;
	}
}
