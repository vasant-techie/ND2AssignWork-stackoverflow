package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.PermissionDTO;

public class PermissionOutput {

	private List<PermissionDTO> listResult = new ArrayList<>();

	public List<PermissionDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<PermissionDTO> listResult) {
		this.listResult = listResult;
	}
}
