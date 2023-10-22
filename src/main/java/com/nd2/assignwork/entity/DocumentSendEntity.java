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
@Table(name = "Document_Send")
public class DocumentSendEntity {

	@Id
	@Column(name = "Document_Send_ID", columnDefinition = "varchar(20)")
	private String documentSendID;
	
	@Column(name = "Document_Send_Title", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String documentSendTitle;
	
	@Column(name = "Document_Send_Content", columnDefinition = "nvarchar(255)")
	@NotBlank
	private String documentSendContent;
	
	@Column(name = "Document_Send_Time", columnDefinition = "datetime")
	@CreationTimestamp
	private Date documentSendTime;
	
	@Column(name = "Document_Send_Deadline", columnDefinition = "datetime")
	private Date documentSendDeadline;
	
	@Column(name = "Document_Send_State", columnDefinition = "int default 0")
	private int documentSendState;
	
	// Foreign key Document_Send_UserSend
	@ManyToOne
	@JoinColumn(name = "Document_Send_UserSend")
	@NotNull
	private UserAccountEntity documentSendUserSend;
	
	// Foreign key User_Receive_Document
	@ManyToMany(mappedBy = "documentSend")
	private Set<UserAccountEntity> userAccount = new HashSet<>();
	
	// Foreign key Document_Send_File
	@ManyToMany(mappedBy = "documentSendFile")
	private Set<FileEntity> File = new HashSet<>();

	public String getDocumentSendID() {
		return documentSendID;
	}

	public void setDocumentSendID(String documentSendID) {
		this.documentSendID = documentSendID;
	}

	public String getDocumentSendTitle() {
		return documentSendTitle;
	}

	public void setDocumentSendTitle(String documentSendTitle) {
		this.documentSendTitle = documentSendTitle;
	}

	public String getDocumentSendContent() {
		return documentSendContent;
	}

	public void setDocumentSendContent(String documentSendContent) {
		this.documentSendContent = documentSendContent;
	}

	public Date getDocumentSendTime() {
		return documentSendTime;
	}

	public void setDocumentSendTime(Date documentSendTime) {
		this.documentSendTime = documentSendTime;
	}

	public Date getDocumentSendDeadline() {
		return documentSendDeadline;
	}

	public void setDocumentSendDeadline(Date documentSendDeadline) {
		this.documentSendDeadline = documentSendDeadline;
	}

	public int getDocumentSendState() {
		return documentSendState;
	}

	public void setDocumentSendState(int documentSendState) {
		this.documentSendState = documentSendState;
	}

	public UserAccountEntity getDocumentSendUserSend() {
		return documentSendUserSend;
	}

	public void setDocumentSendUserSend(UserAccountEntity documentSendUserSend) {
		this.documentSendUserSend = documentSendUserSend;
	}

	public Set<UserAccountEntity> getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Set<UserAccountEntity> userAccount) {
		this.userAccount = userAccount;
	}

	public Set<FileEntity> getFile() {
		return File;
	}

	public void setFile(Set<FileEntity> file) {
		File = file;
	}
}
