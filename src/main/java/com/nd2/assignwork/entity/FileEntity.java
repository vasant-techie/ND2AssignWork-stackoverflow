package com.nd2.assignwork.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "File")
public class FileEntity {

	@Id
	@Column(name = "File_ID", columnDefinition = "varchar(20)")
	private String fileID;
	
	@Column(name = "File_Name", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String fileName;
	
	// Foreign key Task_File
	@ManyToMany
	@JoinTable(name = "Task_File",
		joinColumns = @JoinColumn(name = "File_ID"),
		inverseJoinColumns = @JoinColumn(name = "Task_ID"))
	private Set<TaskEntity> Task = new HashSet<>();
	
	// Foreign key Document_Incoming_File
	@ManyToMany
	@JoinTable(name = "Document_Incoming_File",
		joinColumns = @JoinColumn(name = "File_ID"),
		inverseJoinColumns = @JoinColumn(name = "Document_Incoming_ID"))
	private Set<DocumentIncomingEntity> documentIncoming = new HashSet<>();
	
	// Foreign key Document_Send_File
	@ManyToMany
	@JoinTable(name = "Document_Send_File",
		joinColumns = @JoinColumn(name = "File_ID"),
		inverseJoinColumns = @JoinColumn(name = "Document_Send_ID"))
	private Set<DocumentSendEntity> documentSendFile = new HashSet<>();

	public Set<TaskEntity> getTask() {
		return Task;
	}

	public void setTask(Set<TaskEntity> task) {
		Task = task;
	}

	public String getFileID() {
		return fileID;
	}

	public void setFileID(String fileID) {
		this.fileID = fileID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Set<DocumentIncomingEntity> getDocumentIncoming() {
		return documentIncoming;
	}

	public void setDocumentIncoming(Set<DocumentIncomingEntity> documentIncoming) {
		this.documentIncoming = documentIncoming;
	}

	public Set<DocumentSendEntity> getDocumentSendFile() {
		return documentSendFile;
	}

	public void setDocumentSendFile(Set<DocumentSendEntity> documentSendFile) {
		this.documentSendFile = documentSendFile;
	}
}
