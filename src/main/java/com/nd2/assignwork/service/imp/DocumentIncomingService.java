package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.DocumentIncomingConverter;
import com.nd2.assignwork.dto.DocumentIncomingDTO;
import com.nd2.assignwork.entity.DocumentIncomingEntity;
import com.nd2.assignwork.entity.UserAccountEntity;
import com.nd2.assignwork.repository.DocumentIncomingRepository;
import com.nd2.assignwork.repository.UserAccountRepository;
import com.nd2.assignwork.service.IDocumentIncomingService;

@Service
public class DocumentIncomingService implements IDocumentIncomingService {
	
	@Autowired
	private DocumentIncomingConverter documentIncomingConverter;
	
	@Autowired
	private DocumentIncomingRepository documentIncomingRepository;

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Override
	public DocumentIncomingDTO save(DocumentIncomingDTO documentIncomingDTO) {
		DocumentIncomingEntity documentIncomingEntity = new DocumentIncomingEntity();
		
		DocumentIncomingEntity oldDocumentIncomingEntity = documentIncomingRepository.findOne(documentIncomingDTO.getDocumentIncomingID());
		if(oldDocumentIncomingEntity != null) {
			documentIncomingEntity = documentIncomingConverter.toEntity(documentIncomingDTO, oldDocumentIncomingEntity);
		} else {
			documentIncomingEntity = documentIncomingConverter.toEntity(documentIncomingDTO);
		}
		
		UserAccountEntity userSend = userAccountRepository.findOneByUserUserName(documentIncomingDTO.getDocumentIncomingUserSend());
		documentIncomingEntity.setDocumentIncomingUserSend(userSend);
		
		UserAccountEntity userReceive = userAccountRepository.findOneByUserUserName(documentIncomingDTO.getDocumentIncomingUserReceive());
		documentIncomingEntity.setDocumentIncomingUserReceive(userReceive);
		
		documentIncomingEntity = documentIncomingRepository.save(documentIncomingEntity);
		return documentIncomingConverter.toDTO(documentIncomingEntity);
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids) {
			documentIncomingRepository.delete(id);
		}
	}

	@Override
	public List<DocumentIncomingDTO> findAll() {
		List<DocumentIncomingDTO> result = new ArrayList<>();
		List<DocumentIncomingEntity> entities = documentIncomingRepository.findAll();
		
		for(DocumentIncomingEntity entity: entities) {
			DocumentIncomingDTO dto = documentIncomingConverter.toDTO(entity);
			result.add(dto);
		}
		return result;
	}

}
