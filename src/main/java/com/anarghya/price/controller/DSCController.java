package com.anarghya.price.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.anarghya.price.entity.DSCChannel;
import com.anarghya.price.response.ApiResponse;
import com.anarghya.price.service.DSCServiceImp;

import jakarta.validation.Valid;

@RestController
public class DSCController {

	@Autowired
	private DSCServiceImp dscService;

	@PostMapping("/saveDsc")
	public ResponseEntity<ApiResponse<DSCChannel>> createUser( @Valid @RequestPart("dsc") DSCChannel dsc,@Valid @RequestParam("mou") MultipartFile mou) {
		DSCChannel channel = dscService.saveDSC(dsc, mou);
		return ResponseEntity.ok(new ApiResponse<>("created sucessfully", channel));
	}

//	@GetMapping("/getdsc/{dscid}")
//	public ResponseEntity<ApiResponse<DSCChannel>> getById(@PathVariable Integer dscid) {
//		DSCChannel dsc = dscService.getById(dscid);
//		return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", dsc));
//	}
//
//	@GetMapping("/allDsc")
//	public ResponseEntity<ApiResponse<List<DSCChannel>>> getAll() {
//		List<DSCChannel> channel = dscService.getAll();
//		return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", channel));
//	}
//
//	 @PutMapping("/updateDsc/{dscid}")
//	    public ResponseEntity<ApiResponse<DSCChannel>> updateDsc(@PathVariable Integer dscid,@Valid
//	                                                @RequestPart("dsc") DSCChannel dscDetails,
//	                                                @RequestParam(value = "mou", required = false) MultipartFile mou) {
//	        DSCChannel updatedDsc = dscService.updateDSC(dscid, dscDetails, mou);
//	        return ResponseEntity.ok(new ApiResponse<>("Updated sucessfully", updatedDsc));
//	    }
}
