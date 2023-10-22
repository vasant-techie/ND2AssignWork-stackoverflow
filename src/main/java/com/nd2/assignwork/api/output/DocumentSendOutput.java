package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.DocumentSendDTO;

public class DocumentSendOutput {
	
	private List<DocumentSendDTO> listResult = new ArrayList<>();

	public List<DocumentSendDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<DocumentSendDTO> listResult) {
		this.listResult = listResult;
	}
}
