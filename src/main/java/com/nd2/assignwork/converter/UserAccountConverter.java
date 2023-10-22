package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.common.EncryptMD5;
import com.nd2.assignwork.dto.UserAccountDTO;
import com.nd2.assignwork.entity.UserAccountEntity;

@Component
public class UserAccountConverter {

	// Convert from DTO to Entity
	public UserAccountEntity toEntity(UserAccountDTO dto) {
		UserAccountEntity entity = new UserAccountEntity();
		entity.setUserID(dto.getUserID());
		entity.setUserUserName(dto.getUserUserName());
		entity.setUserFullName(dto.getUserFullName());
		entity.setUserEmail(dto.getUserEmail());
		entity.setUserPassword(EncryptMD5.getPassMD5(dto.getUserPassword()));
		entity.setUserPhone(dto.getUserPhone());
		entity.setUserImage(dto.getUserImage());
		entity.setUserIsActive(dto.getUserIsActive());
		return entity;
	}
	
	// Convert from Entity to DTO
	public UserAccountDTO toDTO(UserAccountEntity entity) {
		UserAccountDTO dto = new UserAccountDTO();
		dto.setUserID(entity.getUserID());
		dto.setUserUserName(entity.getUserUserName());
		dto.setUserFullName(entity.getUserFullName());
		dto.setUserEmail(entity.getUserEmail());
		dto.setUserPassword(entity.getUserPassword());
		dto.setUserPhone(entity.getUserPhone());
		dto.setUserImage(entity.getUserImage());
		dto.setUserIsActive(entity.getUserIsActive());
		if(entity.getUserPosition() != null) {
			dto.setUserPosition(entity.getUserPosition().getPositionName());
		}
		return dto;
	}
	
	// Save update UserAccount by convert from DTO to Entity
	public UserAccountEntity toEntity(UserAccountDTO dto, UserAccountEntity entity) {
		//entity.setUserID(dto.getUserID());
		if(dto.getUserUserName() != null) {
			entity.setUserUserName(dto.getUserUserName());
		}
		if(dto.getUserFullName() != null) {
			entity.setUserFullName(dto.getUserFullName());
		}
		if(dto.getUserEmail() != null) {
			entity.setUserEmail(dto.getUserEmail());
		}
		if(dto.getUserPassword() != null) {
			entity.setUserPassword(EncryptMD5.getPassMD5(dto.getUserPassword()));
		}
		if(dto.getUserPhone() != null) {
			entity.setUserPhone(dto.getUserPhone());
		}
		if(dto.getUserImage() != null) {
			entity.setUserImage(dto.getUserImage());
		}
		entity.setUserIsActive(dto.getUserIsActive());
		return entity;
	}
}
