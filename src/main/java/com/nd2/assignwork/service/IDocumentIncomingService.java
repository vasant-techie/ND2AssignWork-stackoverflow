package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.DocumentIncomingDTO;

public interface IDocumentIncomingService {

	// Save DocumentIncoming from DTO
	DocumentIncomingDTO save(DocumentIncomingDTO documentIncommingDTO);
	// Delete DocumentIncoming
	void delete(String[] ids);
	// Get DocumentIncoming no paging
	List<DocumentIncomingDTO> findAll();
}
