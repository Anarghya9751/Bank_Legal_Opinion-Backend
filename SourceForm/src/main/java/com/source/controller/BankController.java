package com.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.source.apiresponse.ApiResponse;
import com.source.entity.BankEntity;
import com.source.service.BankService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/banks")
public class BankController {

 @Autowired
 private BankService bankService;
 
 
 @PostMapping("/save")
	public ResponseEntity<ApiResponse<BankEntity>> savePrice(@Valid @RequestBody BankEntity bank) {
	 BankEntity banks = bankService.saveBank(bank);
		return ResponseEntity.ok(new ApiResponse<>("Bank Data  Saved sucessfully", banks));
	}
 

 

 @GetMapping("/getAll")
	public ResponseEntity<ApiResponse<List<BankEntity>>> getAll(@Valid @RequestBody BankEntity bank) {
	 List<BankEntity> banks = bankService.getAll();
		return ResponseEntity.ok(new ApiResponse<>("ALL Banks Details Retrived sucessfully", banks));
	}

 
 
 @GetMapping("/{id}")
	public ResponseEntity<ApiResponse<BankEntity>> getBankById(@PathVariable Long id) {
	 BankEntity banks = bankService.getBankById(id);
	 return ResponseEntity.ok(new ApiResponse<>(" bank data retrived sucessfully", banks));
	}
 
 
 
 @PutMapping("/{id}")
 public ResponseEntity<ApiResponse<BankEntity>> update(@Valid @RequestBody BankEntity bank, @PathVariable Long id) {
     BankEntity updatedBank = bankService.updateBank(bank, id);
     return ResponseEntity.ok(new ApiResponse<>("Bank data updated successfully", updatedBank));
 }

 

 @DeleteMapping("/{id}")
 public String deleteBank(@PathVariable Long id) {
   return   bankService.deleteBank(id);
 }




}




