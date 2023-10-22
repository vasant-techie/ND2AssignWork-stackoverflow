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

import com.nd2.assignwork.api.output.DepartmentOutput;
import com.nd2.assignwork.dto.DepartmentDTO;
import com.nd2.assignwork.service.imp.DepartmentService;

@CrossOrigin
@RestController
public class DepartmentAPI {

	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(value = "/api/department")
	public DepartmentOutput showDepartment() {
		DepartmentOutput result = new DepartmentOutput();
		result.setListResult(departmentService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/department")
	public DepartmentDTO createDepartment(@RequestBody DepartmentDTO model) {
		return departmentService.save(model);
	}
	
	@PutMapping(value = "/api/department/{departmentId}")
	public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO model, @PathVariable("departmentId") String departmentId) {
		model.setDepartmentID(departmentId);
		return departmentService.save(model);
	}
	
	@DeleteMapping(value = "/api/department")
	public void deleteDepartment(@RequestBody String[] departmentIds) {
		departmentService.delete(departmentIds);
	}
}
