package com.nd2.assignwork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nd2.assignwork.api.output.FileOutput;
import com.nd2.assignwork.dto.FileDTO;
import com.nd2.assignwork.service.imp.FileService;

@CrossOrigin
@RestController
public class FileAPI {

	@Autowired
	private FileService fileService;
	
	@GetMapping(value = "/api/file")
	public FileOutput showFile() {
		FileOutput result = new FileOutput();
		result.setListResult(fileService.findAll());
		return result;
	}

	@GetMapping(value = "/api/file/{fileId}")
	public FileDTO getSingleUser(@PathVariable("fileId") String fileId) {
		FileDTO file = fileService.findSingleFile(fileId);
	    return file;
	}
	
	@PostMapping(value = "/api/file")
	public FileDTO createFile(@RequestBody FileDTO model) {
		return fileService.save(model);
	}
	
	@PutMapping(value = "/api/file/{fileId}")
	public FileDTO updateFile(@RequestBody FileDTO model, @PathVariable("fileId") String fileId) {
		model.setFileID(fileId);
		return fileService.save(model);
	}
	
	@DeleteMapping(value = "/api/file")
	public void deleteFile(@RequestBody String[] fileIds) {
		fileService.delete(fileIds);
	}
	
	// Task - File
	@PostMapping(value = "/api/file/{fileId}/addTask/{taskId}")
	public void addTaskFile(@PathVariable("fileId") String fileId, @PathVariable("taskId") String taskId) {
		fileService.addTaskForFile(fileId, taskId);
	}
	
	@DeleteMapping(value = "/api/file/{fileId}/deleteTask/{taskId}")
	public void deleteTaskFile(@PathVariable("fileId") String fileId, @PathVariable("taskId") String taskId) {
		fileService.deleteTaskForFile(fileId, taskId);
	}
	
	// Document_Incoming_File
	@PostMapping(value = "/api/file/{fileId}/addDocumentIncoming/{documentIncomingId}")
	public void addDocumentIncomingFile(@PathVariable("fileId") String fileId, @PathVariable("documentIncomingId") String documentIncomingId) {
		fileService.addDocumentIncomingForFile(fileId, documentIncomingId);
	}
	
	@DeleteMapping(value = "/api/file/{fileId}/deleteDocumentIncoming/{documentIncomingId}")
	public void deleteDocumentIncomingFile(@PathVariable("fileId") String fileId, @PathVariable("documentIncomingId") String documentIncomingId) {
		fileService.deleteDocumentIncomingForFile(fileId, documentIncomingId);
	}
	
	// Document_Send_File
	@PostMapping(value = "/api/file/{fileId}/addDocumentSend/{documentSendId}")
	public void addDocumentSendFile(@PathVariable("fileId") String fileId, @PathVariable("documentSendId") String documentSendId) {
		fileService.addDocumentSendForFile(fileId, documentSendId);
	}
	
	@DeleteMapping(value = "/api/file/{fileId}/deleteDocumentSend/{documentSendId}")
	public void deleteDocumentSendFile(@PathVariable("fileId") String fileId, @PathVariable("documentSendId") String documentSendId) {
		fileService.deleteDocumentSendForFile(fileId, documentSendId);
	}
}
