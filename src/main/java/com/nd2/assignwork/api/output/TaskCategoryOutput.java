package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.TaskCategoryDTO;

public class TaskCategoryOutput {

	private List<TaskCategoryDTO> listResult = new ArrayList<>();

	public List<TaskCategoryDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<TaskCategoryDTO> listResult) {
		this.listResult = listResult;
	}
}
