package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.DepartmentDTO;

public class DepartmentOutput {

	private List<DepartmentDTO> listResult = new ArrayList<>();

	public List<DepartmentDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<DepartmentDTO> listResult) {
		this.listResult = listResult;
	}
}
