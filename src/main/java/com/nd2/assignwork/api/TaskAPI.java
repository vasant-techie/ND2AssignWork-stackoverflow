package com.nd2.assignwork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nd2.assignwork.api.output.TaskOutput;
import com.nd2.assignwork.dto.TaskDTO;
import com.nd2.assignwork.service.imp.TaskService;

@CrossOrigin
@RestController
public class TaskAPI {
	
	@Autowired
	private TaskService taskService;

	@GetMapping(value = "/api/task")
	public TaskOutput showTask() {
		TaskOutput result = new TaskOutput();
		result.setListResult(taskService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/task")
	public TaskDTO saveTask(@RequestBody TaskDTO model) {
		return taskService.save(model);
	}
	
	@PutMapping(value = "/api/task/{taskId}")
	public TaskDTO updateTask(@RequestBody TaskDTO model, @PathVariable("taskId") String taskId) {
		model.setTaskID(taskId);
		return taskService.save(model);
	}
	
	@DeleteMapping(value = "/api/task")
	public void deleteTask(@RequestBody String[] taskIds) {
		taskService.delete(taskIds);
	}
}
