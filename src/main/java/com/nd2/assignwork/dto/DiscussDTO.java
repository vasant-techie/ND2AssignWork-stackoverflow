package com.nd2.assignwork.dto;

import lombok.Data;

import java.util.Date;

@Data
public class DiscussDTO {
	private String discussTaskID;
	private String discussUserID;
	private Date discussTime;
	private String discussContent;
}
