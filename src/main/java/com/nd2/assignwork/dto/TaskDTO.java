package com.nd2.assignwork.dto;

import java.util.Date;

public class TaskDTO {
	
	private String taskID;
	private String taskTitle;
	private String taskContent;
	private String taskCategory;
	private Date taskDateSend;
	private Date taskDateEnd;
	private String taskPersonalSend;
	private String taskPersonalReceive;
	private int taskState;

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}

	public String getTaskID() {
		return taskID;
	}

	public void setTaskID(String taskID) {
		this.taskID = taskID;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(String taskCategory) {
		this.taskCategory = taskCategory;
	}

	public Date getTaskDateSend() {
		return taskDateSend;
	}

	public void setTaskDateSend(Date taskDateSend) {
		this.taskDateSend = taskDateSend;
	}

	public Date getTaskDateEnd() {
		return taskDateEnd;
	}

	public void setTaskDateEnd(Date taskDateEnd) {
		this.taskDateEnd = taskDateEnd;
	}

	public String getTaskPersonalSend() {
		return taskPersonalSend;
	}

	public void setTaskPersonalSend(String taskPersonalSend) {
		this.taskPersonalSend = taskPersonalSend;
	}

	public String getTaskPersonalReceive() {
		return taskPersonalReceive;
	}

	public void setTaskPersonalReceive(String taskPersonalReceive) {
		this.taskPersonalReceive = taskPersonalReceive;
	}

	public int getTaskState() {
		return taskState;
	}

	public void setTaskState(int taskState) {
		this.taskState = taskState;
	}
}
