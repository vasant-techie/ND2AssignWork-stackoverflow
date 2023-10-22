package com.nd2.assignwork.converter;

import org.springframework.stereotype.Component;

import com.nd2.assignwork.dto.DocumentSendDTO;
import com.nd2.assignwork.entity.DocumentSendEntity;

@Component
public class DocumentSendConverter {

	// Convert from DTO to Entity
	public DocumentSendEntity toEntity(DocumentSendDTO dto) {
		DocumentSendEntity entity = new DocumentSendEntity();
		entity.setDocumentSendID(dto.getDocumentSendID());
		entity.setDocumentSendTitle(dto.getDocumentSendTitle());
		entity.setDocumentSendContent(dto.getDocumentSendContent());
		entity.setDocumentSendTime(dto.getDocumentSendTime());
		entity.setDocumentSendDeadline(dto.getDocumentSendDeadline());
		entity.setDocumentSendState(dto.getDocumentSendState());
		return entity;
	}
	
	// Convert from Entity to DTO
	public DocumentSendDTO toDTO(DocumentSendEntity entity) {
		DocumentSendDTO dto = new DocumentSendDTO();
		dto.setDocumentSendID(entity.getDocumentSendID());
		dto.setDocumentSendTitle(entity.getDocumentSendTitle());
		dto.setDocumentSendContent(entity.getDocumentSendContent());
		dto.setDocumentSendTime(entity.getDocumentSendTime());
		dto.setDocumentSendDeadline(entity.getDocumentSendDeadline());
		dto.setDocumentSendState(entity.getDocumentSendState());
		if(entity.getDocumentSendUserSend() != null) {
			dto.setDocumentSendUserSend(entity.getDocumentSendUserSend().getUserFullName());
		}
		return dto;
	}
	
	// Save update DocumentSend by convert from DTO to Entity
	public DocumentSendEntity toEntity(DocumentSendDTO dto, DocumentSendEntity entity) {
		//entity.setDocumentSendID(dto.getDocumentSendID());
		if(dto.getDocumentSendTitle() != null) {
			entity.setDocumentSendTitle(dto.getDocumentSendTitle());
		}
		if(dto.getDocumentSendContent() != null) {
			entity.setDocumentSendContent(dto.getDocumentSendContent());
		}
		if(dto.getDocumentSendTime() != null) {
			entity.setDocumentSendTime(dto.getDocumentSendTime());
		}
		if(dto.getDocumentSendDeadline() != null) {
			entity.setDocumentSendDeadline(dto.getDocumentSendDeadline());
		}
		entity.setDocumentSendState(dto.getDocumentSendState());
		return entity;
	}
}
