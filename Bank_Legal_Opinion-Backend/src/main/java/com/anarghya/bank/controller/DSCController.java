package com.anarghya.bank.controller;

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

import com.anarghya.bank.entity.DSCChannel;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.service.DSCServiceImp;

@RestController
public class DSCController {

	@Autowired
	private DSCServiceImp dscService;

	@PostMapping("/saveDsc")
	public DSCChannel createUser(@RequestPart("dsc") DSCChannel dsc, @RequestParam("mou") MultipartFile mou) {
		return dscService.saveDSC(dsc, mou);
	}

	@GetMapping("/getdsc/{dscid}")
	public ResponseEntity<DSCChannel> getById(@PathVariable Integer dscid) {
		DSCChannel dsc = dscService.getById(dscid);
		return ResponseEntity.ok(dsc);
	}

	@GetMapping("/allDsc")
	public List<DSCChannel> getAll() {
		return dscService.getAll();
	}

	 @PutMapping("/updateDsc/{dscid}")
	    public ResponseEntity<DSCChannel> updateDsc(@PathVariable Integer dscid,
	                                                @RequestPart("dsc") DSCChannel dscDetails,
	                                                @RequestParam(value = "mou", required = false) MultipartFile mou) {
	        DSCChannel updatedDsc = dscService.updateDSC(dscid, dscDetails, mou);
	        return ResponseEntity.ok(updatedDsc);
	    }
}
