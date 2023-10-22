package com.nd2.assignwork.dto;

public class TaskCategoryDTO {
	
	private Integer taskCategoryID;
	private String categoryName;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getTaskCategoryID() {
		return taskCategoryID;
	}

	public void setTaskCategoryID(Integer taskCategoryID) {
		this.taskCategoryID = taskCategoryID;
	}
}
