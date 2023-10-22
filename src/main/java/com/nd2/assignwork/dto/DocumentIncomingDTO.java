package com.nd2.assignwork.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class DocumentIncomingDTO {
	private String documentIncomingID;
	private String documentIncomingTitle;
	private String documentIncomingContent;
	private Date documentIncomingTime;
	private int documentIncomingState;
	private String documentIncomingUserSend;
	private String documentIncomingUserReceive;
}
