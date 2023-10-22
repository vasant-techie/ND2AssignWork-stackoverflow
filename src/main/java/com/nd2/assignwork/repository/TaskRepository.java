package com.nd2.assignwork.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nd2.assignwork.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, String> {

	// Find single Task by title
	TaskEntity findOneByTaskTitle(String taskTitle);
	TaskEntity findOneByTaskID(String taskID);

}
