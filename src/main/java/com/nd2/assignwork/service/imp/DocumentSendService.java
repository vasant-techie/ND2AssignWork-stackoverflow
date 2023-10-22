package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.DocumentSendConverter;
import com.nd2.assignwork.dto.DocumentSendDTO;
import com.nd2.assignwork.entity.DocumentSendEntity;
import com.nd2.assignwork.entity.UserAccountEntity;
import com.nd2.assignwork.repository.DocumentSendRepository;
import com.nd2.assignwork.repository.UserAccountRepository;
import com.nd2.assignwork.service.IDocumentSendService;

@Service
public class DocumentSendService implements IDocumentSendService {
	
	@Autowired
	private DocumentSendConverter documentSendConverter;
	
	@Autowired
	private DocumentSendRepository documentSendRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public DocumentSendDTO save(DocumentSendDTO documentSendDTO) {
		DocumentSendEntity documentSendEntity = new DocumentSendEntity();
		
		DocumentSendEntity oldDocumentSendEntity = documentSendRepository.findOne(documentSendDTO.getDocumentSendID());
		if(oldDocumentSendEntity != null) {
			documentSendEntity = documentSendConverter.toEntity(documentSendDTO, oldDocumentSendEntity);
		} else {
			documentSendEntity = documentSendConverter.toEntity(documentSendDTO);
		}
		
		UserAccountEntity userSend = userAccountRepository.findOneByUserUserName(documentSendDTO.getDocumentSendUserSend());
		documentSendEntity.setDocumentSendUserSend(userSend);
		
		documentSendEntity = documentSendRepository.save(documentSendEntity);
		return documentSendConverter.toDTO(documentSendEntity);
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids) {
			documentSendRepository.delete(id);
		}
	}

	@Override
	public List<DocumentSendDTO> findAll() {
		List<DocumentSendDTO> result = new ArrayList<>();
		List<DocumentSendEntity> entities = documentSendRepository.findAll();
		
		for(DocumentSendEntity entity: entities) {
			DocumentSendDTO dto = documentSendConverter.toDTO(entity);
			result.add(dto);
		}
		return result;
	}
}
