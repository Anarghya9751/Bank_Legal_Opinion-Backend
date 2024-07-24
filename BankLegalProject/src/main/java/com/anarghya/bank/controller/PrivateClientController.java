package com.anarghya.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anarghya.bank.entity.PrivateClientChannel;
import com.anarghya.bank.service.PrivateClientServiceImp;

@RestController
public class PrivateClientController {
	
	@Autowired
	private PrivateClientServiceImp privateClientService;
	
	@PostMapping("/saveClient")
	public PrivateClientChannel saveClient(@RequestBody PrivateClientChannel pvtclient) {
		return privateClientService.saveClient(pvtclient);
	}
	@GetMapping("/getclient/{pvtclientid}")
	public PrivateClientChannel getById(@PathVariable Integer pvtclientid) {
		return privateClientService.getById(pvtclientid);
	}
	
	@GetMapping("/getAllClient")
	public List<PrivateClientChannel> getAll() {
		return privateClientService.getAll();
	
	}
	@DeleteMapping("/deleteClient/{pvtclientid}")
	public String deleteById(@PathVariable Integer pvtclientid) {
		return privateClientService.deleteById(pvtclientid) ;
		
	}

}
