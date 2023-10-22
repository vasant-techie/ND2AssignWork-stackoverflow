package com.nd2.assignwork.dto;

import java.util.Date;

public class DocumentSendDTO {

	private String documentSendID;
	private String documentSendTitle;
	private String documentSendContent;
	private Date documentSendTime;
	private Date documentSendDeadline;
	private String documentSendUserSend;
	private int documentSendState;

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

	public String getDocumentSendUserSend() {
		return documentSendUserSend;
	}

	public void setDocumentSendUserSend(String documentSendUserSend) {
		this.documentSendUserSend = documentSendUserSend;
	}

	public int getDocumentSendState() {
		return documentSendState;
	}

	public void setDocumentSendState(int documentSendState) {
		this.documentSendState = documentSendState;
	}
}
