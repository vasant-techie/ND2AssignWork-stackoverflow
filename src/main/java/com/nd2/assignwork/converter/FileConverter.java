package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.FileDTO;
import com.nd2.assignwork.entity.FileEntity;

@Component
public class FileConverter {

	// Convert from DTO to Entity
	public FileEntity toEntity(FileDTO dto) {
		FileEntity entity = new FileEntity();
		entity.setFileID(dto.getFileID());
		entity.setFileName(dto.getFileName());
		return entity;
	}
	
	// Convert from Entity to DTO
	public FileDTO toDTO(FileEntity entity) {
		FileDTO dto = new FileDTO();
		dto.setFileID(entity.getFileID());
		dto.setFileName(entity.getFileName());
		return dto;
	}
	
	// Save update File by convert from DTO to Entity
	public FileEntity toEntity(FileDTO dto, FileEntity entity) {
		//entity.setFileID(dto.getFileID());
		if(dto.getFileName() != null) {
			entity.setFileName(dto.getFileName());
		}
		return entity;
	}
}
