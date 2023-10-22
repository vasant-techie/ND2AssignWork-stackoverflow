package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.PositionDTO;
import com.nd2.assignwork.entity.PositionEntity;

@Component
public class PositionConverter {

	// Convert from DTO to Entity
	public PositionEntity toEntity(PositionDTO dto) {
		PositionEntity entity = new PositionEntity();
		entity.setPositionName(dto.getPositionName());
		return entity;
	}
	
	// Convert from Entity to DTO
	public PositionDTO toDTO(PositionEntity entity) {
		PositionDTO dto = new PositionDTO();
		if(entity.getPositionID() != null) {
			dto.setPositionID(entity.getPositionID());
		}
		dto.setPositionName(entity.getPositionName());
		return dto;
	}
	
	// Save update Position by convert from DTO to Entity
	public PositionEntity toEntity(PositionDTO dto, PositionEntity entity) {
		if(dto.getPositionName() != null) {
			entity.setPositionName(dto.getPositionName());
		}
		return entity;
	}
}
