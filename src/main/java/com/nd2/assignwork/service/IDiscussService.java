package com.nd2.assignwork.service;

import java.util.Date;
import java.util.List;

import com.nd2.assignwork.dto.DiscussDTO;

public interface IDiscussService {
	
	// Save Discuss from DTO
	DiscussDTO save(DiscussDTO discussDTO);
	// Delete Discuss
	void delete(Date[] ids);
	// Get Discuss no paging
	List<DiscussDTO> findAll();
}
