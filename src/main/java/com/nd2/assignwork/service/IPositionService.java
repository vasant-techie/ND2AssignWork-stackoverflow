package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.PositionDTO;

public interface IPositionService {

	// Save Position from DTO
	PositionDTO save(PositionDTO positionDTO);
	// Delete Position
	void delete(int[] ids);
	// Get Position no paging
	List<PositionDTO> findAll();
}
