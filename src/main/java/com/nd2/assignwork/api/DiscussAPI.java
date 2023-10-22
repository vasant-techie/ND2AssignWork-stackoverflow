package com.nd2.assignwork.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nd2.assignwork.api.output.DiscussOutput;
import com.nd2.assignwork.dto.DiscussDTO;
import com.nd2.assignwork.service.imp.DiscussService;

@CrossOrigin
@RestController
public class DiscussAPI {

	@Autowired
	private DiscussService discussService;
	
	@GetMapping(value = "/api/discuss")
	public DiscussOutput showDiscuss() {
		DiscussOutput result = new DiscussOutput();
		result.setListResult(discussService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/discuss")
	public DiscussDTO saveDiscuss(@RequestBody DiscussDTO model) {
		return discussService.save(model);
	}
	
	@PutMapping(value = "/api/discuss/{discussTime}")
	public DiscussDTO updateDiscuss(@RequestBody DiscussDTO model, @PathVariable("discussTime") Date discussTime) {
		model.setDiscussTime(discussTime);
		return discussService.save(model);
	}
	
	@DeleteMapping(value = "/api/discuss")
	public void deleteDiscuss(@RequestBody Date[] discussTimes) {
		discussService.delete(discussTimes);
	}
}
