package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.PermissionDTO;
import com.nd2.assignwork.entity.PermissionEntity;

@Component
public class PermissionConverter {

	// Convert from DTO to Entity
	public PermissionEntity toEntity(PermissionDTO dto) {
		PermissionEntity entity = new PermissionEntity();
		entity.setPermissionName(dto.getPermissionName());
		return entity;
	}
	
	// Convert from Entity to DTO
	public PermissionDTO toDTO(PermissionEntity entity) {
		PermissionDTO dto = new PermissionDTO();
		if(entity.getPermissionID() != null) {
			dto.setPermissionID(entity.getPermissionID());
		}
		dto.setPermissionName(entity.getPermissionName());
		return dto;
	}
	
	// Save update Permission by convert from DTO to Entity
	public PermissionEntity toEntity(PermissionDTO dto, PermissionEntity entity) {
		if(dto.getPermissionName() != null) {
			entity.setPermissionName(dto.getPermissionName());
		}
		return entity;
	}
}
