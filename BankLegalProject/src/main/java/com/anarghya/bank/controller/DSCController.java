package com.anarghya.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public DSCChannel createUser(@RequestParam("mou") MultipartFile mou,@RequestParam Integer dscid,@RequestParam String dscname,@RequestParam String directorname,@RequestParam Long phnum,
			@RequestParam String email,@RequestParam(value="pricing",required = false) List<PricingEntity> pricing) {
		// TODO Auto-generated method stub
		return dscService.saveDSC(mou, dscid, dscname, directorname, phnum, email,pricing);
	}
	@GetMapping("/getDsc/{dscid}")
	public DSCChannel getById(@PathVariable Integer dscid) {
		return dscService.getById(dscid);
	}
	@GetMapping("/allDsc")
	public List<DSCChannel> getAll() {
		
		return dscService.getAll();
	}
	@PutMapping("/updateDsc/{dscid}")
	public DSCChannel updateUser(@PathVariable Integer dscid) {
		return dscService.updateDSC(dscid);
	}
}
