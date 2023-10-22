package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.DepartmentDTO;

public interface IDepartmentService {

	// Save Department from DTO
	DepartmentDTO save(DepartmentDTO departmentDTO);
	// Delete Department
	void delete(String[] ids);
	// Get Department no paging
	List<DepartmentDTO> findAll();
}
