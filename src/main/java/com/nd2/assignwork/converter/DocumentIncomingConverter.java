package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.DocumentIncomingDTO;
import com.nd2.assignwork.entity.DocumentIncomingEntity;

@Component
public class DocumentIncomingConverter {

	// Convert from DTO to Entity
	public DocumentIncomingEntity toEntity(DocumentIncomingDTO dto) {
		DocumentIncomingEntity entity = new DocumentIncomingEntity();
		entity.setDocumentIncomingID(dto.getDocumentIncomingID());
		entity.setDocumentIncomingTitle(dto.getDocumentIncomingTitle());
		entity.setDocumentIncomingContent(dto.getDocumentIncomingContent());
		entity.setDocumentIncomingTime(dto.getDocumentIncomingTime());
		entity.setDocumentIncomingState(dto.getDocumentIncomingState());
		return entity;
	}
	
	// Convert from Entity to DTO
	public DocumentIncomingDTO toDTO(DocumentIncomingEntity entity) {
		DocumentIncomingDTO dto = new DocumentIncomingDTO();
		dto.setDocumentIncomingID(entity.getDocumentIncomingID());
		dto.setDocumentIncomingTitle(entity.getDocumentIncomingTitle());
		dto.setDocumentIncomingContent(entity.getDocumentIncomingContent());
		dto.setDocumentIncomingTime(entity.getDocumentIncomingTime());
		dto.setDocumentIncomingState(entity.getDocumentIncomingState());
		if(entity.getDocumentIncomingUserSend() != null) {
			dto.setDocumentIncomingUserSend(entity.getDocumentIncomingUserSend().getUserFullName());
		}
		if(entity.getDocumentIncomingUserReceive() != null) {
			dto.setDocumentIncomingUserReceive(entity.getDocumentIncomingUserReceive().getUserFullName());
		}
		return dto;
	}
	
	// Save update DocumentIncoming by convert from DTO to Entity
	public DocumentIncomingEntity toEntity(DocumentIncomingDTO dto, DocumentIncomingEntity entity) {
		//entity.setDocumentIncomingID(dto.getDocumentIncomingID());
		if(dto.getDocumentIncomingTitle() != null) {
			entity.setDocumentIncomingTitle(dto.getDocumentIncomingTitle());
		}
		if(dto.getDocumentIncomingContent() != null) {
			entity.setDocumentIncomingContent(dto.getDocumentIncomingContent());
		}
		if(dto.getDocumentIncomingTime() != null) {
			entity.setDocumentIncomingTime(dto.getDocumentIncomingTime());
		}
		entity.setDocumentIncomingState(dto.getDocumentIncomingState());
		return entity;
	}
}
