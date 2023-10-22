package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.DiscussDTO;

public class DiscussOutput {

	private List<DiscussDTO> listResult = new ArrayList<>();

	public List<DiscussDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<DiscussDTO> listResult) {
		this.listResult = listResult;
	}
}
