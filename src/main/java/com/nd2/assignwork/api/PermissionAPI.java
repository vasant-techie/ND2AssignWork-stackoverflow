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

import com.nd2.assignwork.api.output.PermissionOutput;
import com.nd2.assignwork.dto.PermissionDTO;
import com.nd2.assignwork.service.imp.PermissionService;

@CrossOrigin
@RestController
public class PermissionAPI {

	@Autowired
	private PermissionService permissionService;
	
	@GetMapping(value = "/api/permission")
	public PermissionOutput showPermission() {
		PermissionOutput result = new PermissionOutput();
		result.setListResult(permissionService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/permission")
	public PermissionDTO createPermission(@RequestBody PermissionDTO model) {
		return permissionService.save(model);
	}
	
	@PutMapping(value = "/api/permission/{permissionId}")
	public PermissionDTO updatePermission(@RequestBody PermissionDTO model, @PathVariable("permissionId") int permissionId) {
		model.setPermissionID(permissionId);
		return permissionService.save(model);
	}
	
	@DeleteMapping(value = "/api/permission")
	public void deletePermission(@RequestBody int[] permissionIds) {
		permissionService.delete(permissionIds);
	}
}
