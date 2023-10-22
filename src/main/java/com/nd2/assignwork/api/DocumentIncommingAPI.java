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

import com.nd2.assignwork.api.output.DocumentIncomingOutput;
import com.nd2.assignwork.dto.DocumentIncomingDTO;
import com.nd2.assignwork.service.imp.DocumentIncomingService;

@CrossOrigin
@RestController
public class DocumentIncommingAPI {

	@Autowired
	private DocumentIncomingService documentIncommingService;
	
	@GetMapping(value = "/api/documentincomming")
	public DocumentIncomingOutput showDocumentIncomming() {
		DocumentIncomingOutput result = new DocumentIncomingOutput();
		result.setListResult(documentIncommingService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/documentincomming")
	public DocumentIncomingDTO saveDocumentIncomming(@RequestBody DocumentIncomingDTO model) {
		return documentIncommingService.save(model);
	}
	
	@PutMapping(value = "/api/documentincomming/{documentIncommingId}")
	public DocumentIncomingDTO updateDocumentIncomming(@RequestBody DocumentIncomingDTO model,
													   @PathVariable("documentIncommingId") String documentIncommingId) {
		model.setDocumentIncomingID(documentIncommingId);
		return documentIncommingService.save(model);
	}
	
	@DeleteMapping(value = "/api/documentincomming")
	public void deleteDocumentIncomming(@RequestBody String[] documentIncommingIds) {
		documentIncommingService.delete(documentIncommingIds);
	}
}
