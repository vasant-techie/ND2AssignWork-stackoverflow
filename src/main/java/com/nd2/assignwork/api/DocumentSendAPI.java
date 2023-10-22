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

import com.nd2.assignwork.api.output.DocumentSendOutput;
import com.nd2.assignwork.dto.DocumentSendDTO;
import com.nd2.assignwork.service.imp.DocumentSendService;

@CrossOrigin
@RestController
public class DocumentSendAPI {

	@Autowired
	private DocumentSendService documentSendService;
	
	@GetMapping(value = "/api/documentsend")
	public DocumentSendOutput showDocumentSend() {
		DocumentSendOutput result = new DocumentSendOutput();
		result.setListResult(documentSendService.findAll());
		return result;
	}
	
	@PostMapping(value = "/api/documentsend")
	public DocumentSendDTO saveDocumentSend(@RequestBody DocumentSendDTO model) {
		return documentSendService.save(model);
	}
	
	@PutMapping(value = "/api/documentsend/{documentSendId}")
	public DocumentSendDTO updateDocumentSend(@RequestBody DocumentSendDTO model, 
			@PathVariable("documentSendId") String documentSendId) {
		model.setDocumentSendID(documentSendId);
		return documentSendService.save(model);
	}
	
	@DeleteMapping(value = "/api/documentsend")
	public void deleteDocumentSend(@RequestBody String[] documentSendIds) {
		documentSendService.delete(documentSendIds);
	}
}
