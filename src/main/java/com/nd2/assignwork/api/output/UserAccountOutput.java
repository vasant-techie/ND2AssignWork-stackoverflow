package com.nd2.assignwork.api.output;

import java.util.ArrayList;
import java.util.List;

import com.nd2.assignwork.dto.UserAccountDTO;

public class UserAccountOutput {

	private List<UserAccountDTO> listResult = new ArrayList<>();

	public List<UserAccountDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<UserAccountDTO> listResult) {
		this.listResult = listResult;
	}
}
