package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.TaskDTO;

public interface ITaskService {

	// Save Task from DTO
	TaskDTO save(TaskDTO taskDTO);
	// Delete Task
	void delete(String[] ids);
	// Get Task no paging
	List<TaskDTO> findAll();
}
