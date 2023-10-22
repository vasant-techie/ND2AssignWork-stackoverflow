package com.nd2.assignwork.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nd2.assignwork.converter.DocumentIncomingConverter;
import com.nd2.assignwork.converter.DocumentSendConverter;
import com.nd2.assignwork.converter.FileConverter;
import com.nd2.assignwork.converter.TaskConverter;
import com.nd2.assignwork.dto.DocumentIncomingDTO;
import com.nd2.assignwork.dto.DocumentSendDTO;
import com.nd2.assignwork.dto.FileDTO;
import com.nd2.assignwork.dto.TaskDTO;
import com.nd2.assignwork.entity.DocumentIncomingEntity;
import com.nd2.assignwork.entity.DocumentSendEntity;
import com.nd2.assignwork.entity.FileEntity;
import com.nd2.assignwork.entity.TaskEntity;
import com.nd2.assignwork.repository.DocumentIncomingRepository;
import com.nd2.assignwork.repository.DocumentSendRepository;
import com.nd2.assignwork.repository.FileRepository;
import com.nd2.assignwork.repository.TaskRepository;
import com.nd2.assignwork.service.IFileService;

@Service
public class FileService implements IFileService {

	@Autowired
	private FileConverter fileConverter;

	@Autowired
	private FileRepository fileRepository;

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private TaskConverter taskConverter;

	@Autowired
	private DocumentIncomingRepository documentIncomingRepository;

	@Autowired
	private DocumentIncomingConverter documentIncomingConverter;

	@Autowired
	private DocumentSendRepository documentSendRepository;

	@Autowired
	private DocumentSendConverter documentSendConverter;

	@Override
	public FileDTO save(FileDTO fileDTO) {
		FileEntity fileEntity = new FileEntity();

		FileEntity oldFileEntity = fileRepository.findOne(fileDTO.getFileID());
		if (oldFileEntity != null) {
			fileEntity = fileConverter.toEntity(fileDTO, oldFileEntity);
		} else {
			fileEntity = fileConverter.toEntity(fileDTO);
		}

		fileEntity = fileRepository.save(fileEntity);
		return fileConverter.toDTO(fileEntity);
	}

	@Override
	public void delete(String[] ids) {
		for (String id : ids) {
			fileRepository.delete(id);
		}
	}

	@Override
	public List<FileDTO> findAll() {
		List<FileDTO> result = new ArrayList<>();
		List<FileEntity> entities = fileRepository.findAll();

		for (FileEntity entity : entities) {
			FileDTO dto = fileConverter.toDTO(entity);
			// Get list of file's task
			for (TaskEntity task : entity.getTask()) {
				TaskDTO taskDTO = taskConverter.toDTO(task);
				dto.getTask().add(taskDTO.getTaskTitle());
			}
			// Get list of file's document incoming
			for (DocumentIncomingEntity documentIncoming : entity.getDocumentIncoming()) {
				DocumentIncomingDTO documentIncomingDTO = documentIncomingConverter.toDTO(documentIncoming);
				dto.getDocumentIncoming().add(documentIncomingDTO.getDocumentIncomingTitle());
			}
			// Get list of file's document send
			for (DocumentSendEntity documentSend : entity.getDocumentSendFile()) {
				DocumentSendDTO documentSendDTO = documentSendConverter.toDTO(documentSend);
				dto.getDocumentSendFile().add(documentSendDTO.getDocumentSendTitle());
			}
			result.add(dto);
		}
		return result;
	}

	@Override
	public FileDTO findSingleFile(String fileId) {
		FileEntity file = fileRepository.findOne(fileId);
		FileDTO fileDTO = fileConverter.toDTO(file);

		// Get list of file's task
		for (TaskEntity task : file.getTask()) {
			TaskDTO taskDTO = taskConverter.toDTO(task);
			fileDTO.getTask().add(taskDTO.getTaskTitle());
		}
		// Get list of file's document incoming
		for (DocumentIncomingEntity documentIncoming : file.getDocumentIncoming()) {
			DocumentIncomingDTO documentIncomingDTO = documentIncomingConverter.toDTO(documentIncoming);
			fileDTO.getDocumentIncoming().add(documentIncomingDTO.getDocumentIncomingTitle());
		}
		// Get list of file's document send
		for (DocumentSendEntity documentSend : file.getDocumentSendFile()) {
			DocumentSendDTO documentSendDTO = documentSendConverter.toDTO(documentSend);
			fileDTO.getDocumentSendFile().add(documentSendDTO.getDocumentSendTitle());
		}
		return fileDTO;
	}

	// Task - File
	@Override
	public void addTaskForFile(String fileId, String taskId) {
		FileEntity file = fileRepository.findOne(fileId);
		TaskEntity task = taskRepository.findOne(taskId);
		
		if(file != null && task != null) {
			boolean taskExists = file.getTask().contains(task);
			
			if(!taskExists) {
				file.getTask().add(task);
				fileRepository.save(file);
			}
		}
	}

	@Override
	public void deleteTaskForFile(String fileId, String taskId) {
		FileEntity file = fileRepository.findOne(fileId);
		TaskEntity task = taskRepository.findOne(taskId);
		
		if(file != null && task != null) {
			boolean taskExists = file.getTask().contains(task);
			
			if(taskExists) {
				file.getTask().remove(task);
				fileRepository.save(file);
			}
		}
	}

	// Document_Incoming_File
	@Override
	public void addDocumentIncomingForFile(String fileId, String documentIncomingId) {
		FileEntity file = fileRepository.findOne(fileId);
		DocumentIncomingEntity documentIncoming = documentIncomingRepository.findOne(documentIncomingId);
		
		if(file != null && documentIncoming != null) {
			boolean documentIncomingExists = file.getDocumentIncoming().contains(documentIncoming);
			
			if(!documentIncomingExists) {
				file.getDocumentIncoming().add(documentIncoming);
				fileRepository.save(file);
			}
		}
	}

	@Override
	public void deleteDocumentIncomingForFile(String fileId, String documentIncomingId) {
		FileEntity file = fileRepository.findOne(fileId);
		DocumentIncomingEntity documentIncoming = documentIncomingRepository.findOne(documentIncomingId);
		
		if(file != null && documentIncoming != null) {
			boolean documentIncomingExists = file.getDocumentIncoming().contains(documentIncoming);
			
			if(documentIncomingExists) {
				file.getDocumentIncoming().remove(documentIncoming);
				fileRepository.save(file);
			}
		}
	}

	// Document_Send_File
	@Override
	public void addDocumentSendForFile(String fileId, String documentSendId) {
		FileEntity file = fileRepository.findOne(fileId);
		DocumentSendEntity documentSend = documentSendRepository.findOne(documentSendId);
		
		if(file != null && documentSend != null) {
			boolean documentSendExists = file.getDocumentSendFile().contains(documentSend);
			
			if(!documentSendExists) {
				file.getDocumentSendFile().add(documentSend);
				fileRepository.save(file);
			}
		}
	}

	@Override
	public void deleteDocumentSendForFile(String fileId, String documentSendId) {
		FileEntity file = fileRepository.findOne(fileId);
		DocumentSendEntity documentSend = documentSendRepository.findOne(documentSendId);
		
		if(file != null && documentSend != null) {
			boolean documentSendExists = file.getDocumentSendFile().contains(documentSend);
			
			if(documentSendExists) {
				file.getDocumentSendFile().remove(documentSend);
				fileRepository.save(file);
			}
		}
	}
}
