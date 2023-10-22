package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.PositionDTO;

public class PositionOutput {

	private List<PositionDTO> listResult = new ArrayList<>();

	public List<PositionDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<PositionDTO> listResult) {
		this.listResult = listResult;
	}
}
