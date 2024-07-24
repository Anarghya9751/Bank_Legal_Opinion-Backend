package com.anarghya.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anarghya.bank.entity.DirectBankChannel;
import com.anarghya.bank.service.DirectBankServiceImp;

@RestController
public class DirectBankController {
	
	@Autowired
	private DirectBankServiceImp bankService;
	
	@PostMapping("/saveBank")
	public DirectBankChannel saveBank(@RequestBody DirectBankChannel bank) {
		
		return bankService.saveBank(bank);
	}
	
	@GetMapping("/getBank/{bankid}")
	public DirectBankChannel getById(@PathVariable Integer bankid) {
		
		return bankService.getById(bankid);
	}
	
	@GetMapping("/getAllBank")
	public List<DirectBankChannel> getAll() {
		
		return bankService.getAll();
	}

	@PutMapping("/updateBank/{bankid}")
	public DirectBankChannel updateBank(@PathVariable Integer bankid) {
		return bankService.updateBank(bankid);
	}
	
	@DeleteMapping("/deleteBank/{bankid}")
	public String deleteById(@PathVariable Integer bankid) {
		return bankService.deleteById(bankid);
	}
}
