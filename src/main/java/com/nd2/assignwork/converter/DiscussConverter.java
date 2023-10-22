package com.nd2.assignwork.converter;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.DiscussDTO;
import com.nd2.assignwork.entity.DiscussEntity;
import com.nd2.assignwork.repository.TaskRepository;
import com.nd2.assignwork.repository.UserAccountRepository;

@Component
public class DiscussConverter {

	private final TaskRepository taskRepo;
	private final UserAccountRepository userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	public DiscussConverter(TaskRepository taskRepo, UserAccountRepository userRepo) {
		this.taskRepo = taskRepo;
		this.userRepo = userRepo;
	}

	// Convert from DTO to Entity
	public DiscussEntity toEntity(DiscussDTO dto) {
		/*DiscussEntity entity = new DiscussEntity();
		entity.setDiscussTime(dto.getDiscussTime());
		entity.setDiscussContent(dto.getDiscussContent());*/
		//entity.setDiscussTask(taskRepo.findOneByTaskID(dto.getDiscussTask()));
		//entity.setDiscussUser(userRepo.findOneByUserID(dto.getDiscussUser()));

		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return modelMapper.map(dto, DiscussEntity.class);
		//return entity;
	}
	
	// Convert from Entity to DTO
	public DiscussDTO toDTO(DiscussEntity entity) {
		DiscussDTO dto = new DiscussDTO();
		dto.setDiscussTime(entity.getDiscussTime());
		dto.setDiscussContent(entity.getDiscussContent());
		if(entity.getDiscussTask() != null) {
			dto.setDiscussTaskID(entity.getDiscussTask().getTaskID());
		}
		if(entity.getDiscussUser() != null) {
			dto.setDiscussUserID(entity.getDiscussUser().getUserID());
		}
		return dto;
	}
	
	// Save update Discuss by convert from DTO to Entity
	public DiscussEntity toEntity(DiscussDTO dto, DiscussEntity entity) {
		if(dto.getDiscussTime() != null) {
			entity.setDiscussTime(dto.getDiscussTime());
		}
		if(dto.getDiscussContent() != null) {
			entity.setDiscussContent(dto.getDiscussContent());
		}
		return entity;
	}
}
