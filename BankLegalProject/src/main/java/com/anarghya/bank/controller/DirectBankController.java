package com.anarghya.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	private DirectBankServiceImp directBankChannelService;
	
	@PostMapping("/saveDBC")
    public ResponseEntity<DirectBankChannel> createDirectBankChannel(@RequestBody DirectBankChannel directBankChannel) {
        DirectBankChannel savedChannel = directBankChannelService.saveDirectBankChannel(directBankChannel);
        return ResponseEntity.ok(savedChannel);
    }

    @GetMapping("/getallDBC")
    public ResponseEntity<List<DirectBankChannel>> getAllDirectBankChannels() {
        List<DirectBankChannel> channels = directBankChannelService.getAllDirectBankChannels();
        return ResponseEntity.ok(channels);
    }

    @GetMapping("/getDBC/{bankId}")
    public ResponseEntity<DirectBankChannel> getDirectBankChannelById(@PathVariable Integer bankId) {
        DirectBankChannel channel = directBankChannelService.getDirectBankChannelById(bankId);
        return ResponseEntity.ok(channel);
    }

    @PutMapping("/updateDBC/{bankId}")
    public ResponseEntity<DirectBankChannel> updateDirectBankChannel(@PathVariable Integer bankId, @RequestBody DirectBankChannel directBankChannelDetails) {
        DirectBankChannel updatedChannel = directBankChannelService.updateDirectBankChannel(bankId, directBankChannelDetails);
        return ResponseEntity.ok(updatedChannel);
    }

    @DeleteMapping("/deleteDBC/{bankId}")
    public ResponseEntity<String> deleteDirectBankChannel(@PathVariable Integer bankId) {
        String response = directBankChannelService.deleteDirectBankChannel(bankId);
        return ResponseEntity.ok(response);
    }
}