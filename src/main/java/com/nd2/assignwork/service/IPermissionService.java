package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.PermissionDTO;

public interface IPermissionService {

	// Save Permission from DTO
	PermissionDTO save(PermissionDTO permissionDTO);
	// Delete Permission
	void delete(int[] ids);
	// Get Permission no paging
	List<PermissionDTO> findAll();
}
