package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.DocumentIncomingDTO;

public class DocumentIncomingOutput {

	private List<DocumentIncomingDTO> listResult = new ArrayList<>();

	public List<DocumentIncomingDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<DocumentIncomingDTO> listResult) {
		this.listResult = listResult;
	}
}
