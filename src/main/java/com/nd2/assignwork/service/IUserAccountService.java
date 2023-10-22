package com.nd2.assignwork.service;

import java.util.List;

import com.nd2.assignwork.dto.UserAccountDTO;

public interface IUserAccountService {

	// Save UserAccount from DTO
	UserAccountDTO save(UserAccountDTO userAccountDTO);
	// Delete UserAccount
	void delete(String[] ids);
	// Get UserAccount no paging
	List<UserAccountDTO> findAll();
	// Get single user
	UserAccountDTO findSingleUser(String userId);
	// Add permission for user
	void addPermissionForUser(String userId, int permissionId);
	// Delete permission for user
	void deletePermissionForUser(String userId, int permissionId);
	// Add Document Receive for user
	void addDocumentReceiveForUser(String userId, String documentSendId);
	// Delete Document Receive for user
	void deleteDocumentReceiveForUser(String userId, String documentSendId);
}
