package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.DocumentSendDTO;

public interface IDocumentSendService {

	// Save DocumentSend from DTO
	DocumentSendDTO save(DocumentSendDTO documentSendDTO);
	// Delete DocumentSend
	void delete(String[] ids);
	// Get DocumentSend no paging
	List<DocumentSendDTO> findAll();
}
