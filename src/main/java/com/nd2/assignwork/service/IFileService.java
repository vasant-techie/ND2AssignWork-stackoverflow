package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.FileDTO;

public interface IFileService {

	// Save File from DTO
	FileDTO save(FileDTO fileDTO);
	// Delete File
	void delete(String[] ids);
	// Get File no paging
	List<FileDTO> findAll();
	// Get single file
	FileDTO findSingleFile(String fileId);
	// Add task for file
	void addTaskForFile(String fileId, String taskId);
	// Delete task for file
	void deleteTaskForFile(String fileId, String taskId);
	// Add documentIncoming for file
	void addDocumentIncomingForFile(String fileId, String documentIncomingId);
	// Delete documentIncoming for file
	void deleteDocumentIncomingForFile(String fileId, String documentIncomingId);
	// Add documentSend for file
	void addDocumentSendForFile(String fileId, String documentSendId);
	// Delete documentSend for file
	void deleteDocumentSendForFile(String fileId, String documentSendId);
}
