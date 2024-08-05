package com.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.source.entity.BankEntity;
import com.source.service.BankService;


import java.util.List;


@RestController
@RequestMapping("/api/banks")
public class BankController {

 @Autowired
 private BankService bankService;

 @PostMapping("/save")
 public ResponseEntity<BankEntity> createBank(@Validated @RequestBody BankEntity bank ) {
     return ResponseEntity.ok(bankService.saveBank(bank));
 }

 @GetMapping("/getAll")
 public List<BankEntity> getAllBanks() {
     return bankService.getAll();
 }

 @GetMapping("/{id}")
 public ResponseEntity<BankEntity> getBankById(@PathVariable Long id) {
     return ResponseEntity.ok(bankService.getBankById(id));
 }

 @PutMapping("/{id}")
 public ResponseEntity<BankEntity> updateBank(@Validated @RequestBody BankEntity bank, @PathVariable Long id) {
     return ResponseEntity.ok(bankService.updateBank(bank, id));
 }

 @DeleteMapping("/{id}")
 public String deleteBank(@PathVariable Long id) {
   return   bankService.deleteBank(id);
    
 }
}













