package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.FileDTO;

public class FileOutput {

	private List<FileDTO> listResult = new ArrayList<>();

	public List<FileDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<FileDTO> listResult) {
		this.listResult = listResult;
	}
}
