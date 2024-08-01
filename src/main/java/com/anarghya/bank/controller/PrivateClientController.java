package com.anarghya.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anarghya.bank.entity.PrivateClientChannel;
import com.anarghya.bank.exception.IdNotFoundException;
import com.anarghya.bank.response.ApiResponse;
import com.anarghya.bank.service.PrivateClientServiceImp;

import jakarta.validation.Valid;

@RestController
public class PrivateClientController {
	
	@Autowired
	private PrivateClientServiceImp privateClientService;
	
	@PostMapping("/saveClient")
	public ResponseEntity<ApiResponse<PrivateClientChannel>> saveClient(@Valid @RequestBody PrivateClientChannel pvtclient) {
		PrivateClientChannel client = privateClientService.saveClient(pvtclient);
		return ResponseEntity.ok(new ApiResponse<>("created sucessfully", client));
	}
	@GetMapping("/getclient/{pvtclientid}")
	public ResponseEntity<ApiResponse<PrivateClientChannel>> getById(@PathVariable Integer pvtclientid) {
		PrivateClientChannel client =privateClientService.getById(pvtclientid);
		return  ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", client));
	}
	
	@GetMapping("/getAllClient")
	public ResponseEntity<ApiResponse<List<PrivateClientChannel>>> getAll() {
		List<PrivateClientChannel> client = privateClientService.getAll();
		return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", client));
	
	}
	@DeleteMapping("/deleteClient/{pvtclientid}")
	public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Integer pvtclientid) {
		String str= privateClientService.deleteById(pvtclientid) ;
		 return ResponseEntity.ok(new ApiResponse<>(str, null));
		
	}

}
