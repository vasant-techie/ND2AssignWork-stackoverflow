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

import com.nd2.assignwork.api.output.TaskCategoryOutput;
import com.nd2.assignwork.dto.TaskCategoryDTO;
import com.nd2.assignwork.service.imp.TaskCategoryService;

@CrossOrigin
@RestController
public class TaskCategoryAPI {

	@Autowired
	private TaskCategoryService taskCategoryService;
	
	@GetMapping(value = "/api/taskcategory")
	public TaskCategoryOutput showTaskCategory() {
		TaskCategoryOutput result = new TaskCategoryOutput();
		result.setListResult(taskCategoryService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/taskcategory")
	public TaskCategoryDTO createTaskCategory(@RequestBody TaskCategoryDTO model) {
		return taskCategoryService.save(model);
	}
	
	@PutMapping(value = "/api/taskcategory/{taskCategoryId}")
	public TaskCategoryDTO updateTaskCategory(@RequestBody TaskCategoryDTO model, @PathVariable("taskCategoryId") int taskCategoryId) {
		model.setTaskCategoryID(taskCategoryId);
		return taskCategoryService.save(model);
	}
	
	@DeleteMapping(value = "/api/taskcategory")
	public void deleteTaskCategory(@RequestBody int[] taskCategoryIds) {
		taskCategoryService.delete(taskCategoryIds);
	}
}
