package com.nd2.assignwork.dto;

import java.util.ArrayList;
import java.util.List;

public class FileDTO {

	private String fileID;
	private String fileName;
	
	private List<String> task = new ArrayList<>();
	private List<String> documentIncoming = new ArrayList<>();
	private List<String> documentSendFile = new ArrayList<>();

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public List<String> getDocumentIncoming() {
		return documentIncoming;
	}

	public void setDocumentIncoming(List<String> documentIncoming) {
		this.documentIncoming = documentIncoming;
	}

	public List<String> getDocumentSendFile() {
		return documentSendFile;
	}

	public void setDocumentSendFile(List<String> documentSendFile) {
		this.documentSendFile = documentSendFile;
	}

	public List<String> getTask() {
		return task;
	}

	public void setTask(List<String> task) {
		this.task = task;
	}
}
