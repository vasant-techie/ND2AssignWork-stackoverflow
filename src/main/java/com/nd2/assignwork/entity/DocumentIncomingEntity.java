package com.nd2.assignwork.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Document_Incoming")
public class DocumentIncomingEntity {

	@Id
	@Column(name = "Document_Incoming_ID", columnDefinition = "varchar(20)")
	private String documentIncomingID;
	
	@Column(name = "Document_Incoming_Title", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String documentIncomingTitle;
	
	@Column(name = "Document_Incoming_Content", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String documentIncomingContent;
	
	@Column(name = "Document_Incoming_Time", columnDefinition = "datetime")
	@CreationTimestamp
	private Date documentIncomingTime;
	
	@Column(name = "Document_Incoming_State", columnDefinition = "int default 0")
	private int documentIncomingState;
	
	// Foreign key Document_Incoming_UserSend
	@ManyToOne
	@JoinColumn(name = "Document_Incoming_UserSend")
	@NotNull
	private UserAccountEntity documentIncomingUserSend;
	
	// Foreign key Document_Incoming_UserReceive
	@ManyToOne
	@JoinColumn(name = "Document_Incoming_UserReceive")
	@NotNull
	private UserAccountEntity documentIncomingUserReceive;
	
	// Foreign key Document_Incoming_File
	@ManyToMany(mappedBy = "documentIncoming")
	private Set<FileEntity> File = new HashSet<>();

	public String getDocumentIncomingID() {
		return documentIncomingID;
	}

	public void setDocumentIncomingID(String documentIncomingID) {
		this.documentIncomingID = documentIncomingID;
	}

	public String getDocumentIncomingTitle() {
		return documentIncomingTitle;
	}

	public void setDocumentIncomingTitle(String documentIncomingTitle) {
		this.documentIncomingTitle = documentIncomingTitle;
	}

	public String getDocumentIncomingContent() {
		return documentIncomingContent;
	}

	public void setDocumentIncomingContent(String documentIncomingContent) {
		this.documentIncomingContent = documentIncomingContent;
	}

	public Date getDocumentIncomingTime() {
		return documentIncomingTime;
	}

	public void setDocumentIncomingTime(Date documentIncomingTime) {
		this.documentIncomingTime = documentIncomingTime;
	}

	public int getDocumentIncomingState() {
		return documentIncomingState;
	}

	public void setDocumentIncomingState(int documentIncomingState) {
		this.documentIncomingState = documentIncomingState;
	}

	public UserAccountEntity getDocumentIncomingUserSend() {
		return documentIncomingUserSend;
	}

	public void setDocumentIncomingUserSend(UserAccountEntity documentIncomingUserSend) {
		this.documentIncomingUserSend = documentIncomingUserSend;
	}

	public UserAccountEntity getDocumentIncomingUserReceive() {
		return documentIncomingUserReceive;
	}

	public void setDocumentIncomingUserReceive(UserAccountEntity documentIncomingUserReceive) {
		this.documentIncomingUserReceive = documentIncomingUserReceive;
	}

	public Set<FileEntity> getFile() {
		return File;
	}

	public void setFile(Set<FileEntity> file) {
		File = file;
	}
}
