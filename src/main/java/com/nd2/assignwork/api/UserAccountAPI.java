package com.nd2.assignwork.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nd2.assignwork.api.output.UserAccountOutput;
import com.nd2.assignwork.dto.UserAccountDTO;
import com.nd2.assignwork.service.imp.UserAccountService;

@CrossOrigin
@RestController
public class UserAccountAPI {

	@Autowired
	private UserAccountService userAccountService;
	
	@GetMapping(value = "/api/useraccount")
	public UserAccountOutput showUserAccount() {
		UserAccountOutput result = new UserAccountOutput();
		result.setListResult(userAccountService.findAll());
		return result;
	}
	
	@GetMapping(value = "/api/useraccount/{userId}")
	public UserAccountDTO getSingleUser(@PathVariable("userId") String userId) {
		UserAccountDTO user = userAccountService.findSingleUser(userId);
	    return user;
	}
	
	@PostMapping(value = "/api/useraccount")
	public UserAccountDTO createUserAccount(@RequestBody UserAccountDTO model) {
		return userAccountService.save(model);
	}
	
	@PutMapping(value = "/api/useraccount/{userId}")
	public UserAccountDTO updateUserAccount(@RequestBody UserAccountDTO model, @PathVariable("userId") String userId) {
		model.setUserID(userId);
		return userAccountService.save(model);
	}
	
	@DeleteMapping(value = "/api/useraccount")
	public void deleteUserAccount(@RequestBody String[] userIds) {
		userAccountService.delete(userIds);
	}
	
	// UserAccount - Permission
	@PostMapping(value = "/api/useraccount/{userId}/addPermission/{permissionId}")
	public void addUserPermission(@PathVariable("userId") String userId, @PathVariable("permissionId") int permissionId) {
	    userAccountService.addPermissionForUser(userId, permissionId);
	}
	
	@DeleteMapping(value = "/api/useraccount/{userId}/deletePermission/{permissionId}")
	public void deleteUserPermission(@PathVariable("userId") String userId, @PathVariable("permissionId") int permissionId) {
	    userAccountService.deletePermissionForUser(userId, permissionId);
	}
	
	// User - Receive - Document
	@PostMapping(value = "/api/useraccount/{userId}/addDocumentSend/{documentSendId}")
	public void addUserReceiveDocument(@PathVariable("userId") String userId, @PathVariable("documentSendId") String documentSendId) {
	    userAccountService.addDocumentReceiveForUser(userId, documentSendId);
	}
	
	@DeleteMapping(value = "/api/useraccount/{userId}/deleteDocumentSend/{documentSendId}")
	public void deleteUserReceiveDocument(@PathVariable("userId") String userId, @PathVariable("documentSendId") String documentSendId) {
	    userAccountService.deleteDocumentReceiveForUser(userId, documentSendId);
	}
}
