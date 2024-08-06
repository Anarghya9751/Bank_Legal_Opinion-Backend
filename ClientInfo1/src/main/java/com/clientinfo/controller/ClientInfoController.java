package com.clientinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.clientinfo.entity.ClientInfoEntity;
import com.clientinfo.response.ApiResponse;
import com.clientinfo.service.ClientInfoService;

@RestController
@RequestMapping("/Client")
public class ClientInfoController {

	@Autowired
	private ClientInfoService clientInfoService;


	@PostMapping("/save")
	public ResponseEntity<ClientInfoEntity> createClientInfo(@RequestPart("clientInfo") ClientInfoEntity clientInfo,
			@RequestParam("adharcard") MultipartFile adharcard, @RequestParam("panCard") MultipartFile panCard,
			@RequestParam("passport") MultipartFile passport) {
		ClientInfoEntity savedClientInfo = clientInfoService.saveclientinfo(clientInfo, adharcard, panCard, passport);
		return new ResponseEntity<>(savedClientInfo, HttpStatus.CREATED);
	}
	
	 @PutMapping("/update/{id}")
	    public ResponseEntity<ClientInfoEntity> updateClientInfo(
	            @PathVariable("id") Long id,
	            @RequestPart("clientInfo") ClientInfoEntity clientInfo,
	            @RequestParam(value = "adharcard", required = false) MultipartFile adharcard,
	            @RequestParam(value = "panCard", required = false) MultipartFile panCard,
	            @RequestParam(value = "passport", required = false) MultipartFile passport) {

	        try {
	            ClientInfoEntity updatedClientInfo = clientInfoService.updateClientInfo(id, clientInfo, adharcard, panCard, passport);
	            return new ResponseEntity<>(updatedClientInfo, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	 
	 
	 

	// Get client by ID
	@GetMapping("/get/{id}")
	public ResponseEntity<ApiResponse<ClientInfoEntity>> getClientInfoById(@PathVariable Long id) {
		ClientInfoEntity client = clientInfoService.getClientInfoById(id);
		return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", client));
	}

	// Get all clients
	@GetMapping
	public ResponseEntity<List<ClientInfoEntity>> getAllClientInfo() {
		List<ClientInfoEntity> clientInfos = clientInfoService.getAllclients();
		return ResponseEntity.ok(clientInfos);
	}

	// Delete client by ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		try {
			clientInfoService.deleteById(id);
			return ResponseEntity.ok("Client deleted successfully");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID");
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
		}

	}
}
