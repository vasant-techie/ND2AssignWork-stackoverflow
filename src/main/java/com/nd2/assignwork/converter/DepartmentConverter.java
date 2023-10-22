package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.DepartmentDTO;
import com.nd2.assignwork.entity.DepartmentEntity;

@Component
public class DepartmentConverter {

	// Convert from DTO to Entity
	public DepartmentEntity toEntity(DepartmentDTO dto) {
		DepartmentEntity entity = new DepartmentEntity();
		entity.setDepartmentID(dto.getDepartmentID());
		entity.setDepartmentName(dto.getDepartmentName());
		return entity;
	}
	
	// Convert from Entity to DTO
	public DepartmentDTO toDTO(DepartmentEntity entity) {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartmentID(entity.getDepartmentID());
		dto.setDepartmentName(entity.getDepartmentName());

		return dto;
	}
	
	// Save update Department by convert from DTO to Entity
	public DepartmentEntity toEntity(DepartmentDTO dto, DepartmentEntity entity) {
		//entity.setDepartmentID(dto.getDepartmentID());
		if(dto.getDepartmentName() != null) {
			entity.setDepartmentName(dto.getDepartmentName());
		}
		return entity;
	}
}
