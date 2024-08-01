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
import com.anarghya.bank.response.ApiResponse;
import com.anarghya.bank.service.DirectBankServiceImp;

import jakarta.validation.Valid;

@RestController
public class DirectBankController {
	
	@Autowired
	private DirectBankServiceImp directBankChannelService;
	
	@PostMapping("/saveDBC")
    public ResponseEntity<ApiResponse<DirectBankChannel>> createDirectBankChannel(@Valid @RequestBody DirectBankChannel directBankChannel) {
        DirectBankChannel savedChannel = directBankChannelService.saveDirectBankChannel(directBankChannel);
        return ResponseEntity.ok(new ApiResponse<>("created sucessfully", savedChannel));
    }

    @GetMapping("/getallDBC")
    public ResponseEntity<ApiResponse<List<DirectBankChannel>>> getAllDirectBankChannels() {
        List<DirectBankChannel> channels = directBankChannelService.getAllDirectBankChannels();
        return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", channels));
    }

    @GetMapping("/getDBC/{bankId}")
    public ResponseEntity<ApiResponse<DirectBankChannel>> getDirectBankChannelById(@PathVariable Integer bankId) {
        DirectBankChannel channel = directBankChannelService.getDirectBankChannelById(bankId);
        return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", channel));
    }

    @PutMapping("/updateDBC/{bankId}")
    public ResponseEntity<ApiResponse<DirectBankChannel>> updateDirectBankChannel(@PathVariable Integer bankId,@Valid @RequestBody DirectBankChannel directBankChannelDetails) {
        DirectBankChannel updatedChannel = directBankChannelService.updateDirectBankChannel(bankId, directBankChannelDetails);
        return ResponseEntity.ok(new ApiResponse<>("Updated Successfully", updatedChannel));
    }

    @DeleteMapping("/deleteDBC/{bankId}")
    public ResponseEntity<ApiResponse<String>> deleteDirectBankChannel(@PathVariable Integer bankId) {
        String response = directBankChannelService.deleteDirectBankChannel(bankId);
        return ResponseEntity.ok(new ApiResponse<>(response, null));
    }
}