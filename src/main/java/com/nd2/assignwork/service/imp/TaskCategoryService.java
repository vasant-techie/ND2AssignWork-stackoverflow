package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.TaskCategoryConverter;
import com.nd2.assignwork.dto.TaskCategoryDTO;
import com.nd2.assignwork.entity.TaskCategoryEntity;
import com.nd2.assignwork.repository.TaskCategoryRepository;
import com.nd2.assignwork.service.ITaskCategoryService;

@Service
public class TaskCategoryService implements ITaskCategoryService {
	
	@Autowired
	private TaskCategoryConverter taskCategoryConverter;
	
	@Autowired
	private TaskCategoryRepository taskCategoryRepository;

	@Override
	public TaskCategoryDTO save(TaskCategoryDTO taskCategoryDTO) {
		TaskCategoryEntity taskCategoryEntity = new TaskCategoryEntity();

		if(taskCategoryDTO.getTaskCategoryID() != null) {
			TaskCategoryEntity oldTaskCategoryEntity = taskCategoryRepository.findOne(taskCategoryDTO.getTaskCategoryID());
			taskCategoryEntity = taskCategoryConverter.toEntity(taskCategoryDTO, oldTaskCategoryEntity);
		} else {
			taskCategoryEntity = taskCategoryConverter.toEntity(taskCategoryDTO);
		}
		
		taskCategoryEntity = taskCategoryRepository.save(taskCategoryEntity);
		return taskCategoryConverter.toDTO(taskCategoryEntity);
	}

	@Override
	public void delete(int[] ids) {
		for(int id: ids) {
			taskCategoryRepository.delete(id);
		}
	}

	@Override
	public List<TaskCategoryDTO> findAll() {
		List<TaskCategoryDTO> result = new ArrayList<>();
		List<TaskCategoryEntity> entities = taskCategoryRepository.findAll();
		
		for(TaskCategoryEntity entity: entities) {
			TaskCategoryDTO dto = taskCategoryConverter.toDTO(entity);
			result.add(dto);
		}
		return result;
	}

}
