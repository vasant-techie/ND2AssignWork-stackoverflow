package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.TaskDTO;
import com.nd2.assignwork.entity.TaskEntity;

@Component
public class TaskConverter {

	// Convert from DTO to Entity
	public TaskEntity toEntity(TaskDTO dto) {
		TaskEntity entity = new TaskEntity();
		entity.setTaskID(dto.getTaskID());
		entity.setTaskTitle(dto.getTaskTitle());
		entity.setTaskContent(dto.getTaskContent());
		entity.setTaskDateSend(dto.getTaskDateSend());
		entity.setTaskDateEnd(dto.getTaskDateEnd());
		entity.setTaskState(dto.getTaskState());
		return entity;
	}
	
	// Convert from Entity to DTO
	public TaskDTO toDTO(TaskEntity entity) {
		TaskDTO dto = new TaskDTO();
		dto.setTaskID(entity.getTaskID());
		dto.setTaskTitle(entity.getTaskTitle());
		dto.setTaskContent(entity.getTaskContent());
		dto.setTaskDateSend(entity.getTaskDateSend());
		dto.setTaskDateEnd(entity.getTaskDateEnd());
		dto.setTaskState(entity.getTaskState());
		if(entity.getTaskCategory() != null) {
			dto.setTaskCategory(entity.getTaskCategory().getCategoryName());
		}
		if(entity.getTaskPersonalSend() != null) {
			dto.setTaskPersonalSend(entity.getTaskPersonalSend().getUserFullName());
		}
		if(entity.getTaskPersonalReceive() != null) {
			dto.setTaskPersonalReceive(entity.getTaskPersonalReceive().getUserFullName());
		}
		return dto;
	}
	
	// Save update Task by convert from DTO to Entity
	public TaskEntity toEntity(TaskDTO dto, TaskEntity entity) {
		//entity.setTaskID(dto.getTaskID());
		if(dto.getTaskTitle() != null) {
			entity.setTaskTitle(dto.getTaskTitle());
		}
		if(dto.getTaskContent() != null) {
			entity.setTaskContent(dto.getTaskContent());
		}
		if(dto.getTaskDateSend() != null) {
			entity.setTaskDateSend(dto.getTaskDateSend());
		}
		if(dto.getTaskDateEnd() != null) {
			entity.setTaskDateEnd(dto.getTaskDateEnd());
		}
		entity.setTaskState(dto.getTaskState());
		return entity;
	}
}
