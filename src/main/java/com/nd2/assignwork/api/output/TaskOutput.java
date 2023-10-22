package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.TaskDTO;

public class TaskOutput {

	private List<TaskDTO> listResult = new ArrayList<>();

	public List<TaskDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<TaskDTO> listResult) {
		this.listResult = listResult;
	}
}
