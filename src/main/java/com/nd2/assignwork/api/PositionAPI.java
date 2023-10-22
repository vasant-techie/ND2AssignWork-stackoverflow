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

import com.nd2.assignwork.api.output.PositionOutput;
import com.nd2.assignwork.dto.PositionDTO;
import com.nd2.assignwork.service.imp.PositionService;

@CrossOrigin
@RestController
public class PositionAPI {
	
	@Autowired
	private PositionService positionService;

	@GetMapping(value = "/api/position")
	public PositionOutput showPosition() {
		PositionOutput result = new PositionOutput();
		result.setListResult(positionService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/position")
	public PositionDTO createPosition(@RequestBody PositionDTO model) {
		return positionService.save(model);
	}
	
	@PutMapping(value = "/api/position/{positionId}")
	public PositionDTO updatePosition(@RequestBody PositionDTO model, @PathVariable("positionId") int positionId) {
		model.setPositionID(positionId);
		return positionService.save(model);
	}
	
	@DeleteMapping(value = "/api/position")
	public void deletePosition(@RequestBody int[] positionIds) {
		positionService.delete(positionIds);
	}
}
