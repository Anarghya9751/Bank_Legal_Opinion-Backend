package com.anarghya.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anarghya.bank.entity.BranchEntity;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.service.BranchServiceImp;
import com.anarghya.bank.service.PricingServiceImp;

@RestController
public class BranchAndPricingController {

	@Autowired
	private BranchServiceImp branchService;
	@Autowired
	private PricingServiceImp pricingService;

	@PostMapping("/savebranch")
	public BranchEntity saveBranch(@RequestBody BranchEntity branch) {
		return branchService.saveBranch(branch);
	}

	@PutMapping("/updatebranch/{branchId}")
	public BranchEntity updateBranch(@PathVariable Integer branchId) {
		return branchService.updateBranch(branchId);
	}

	@GetMapping("/getbranch/{branchId}")
	public BranchEntity getById(@PathVariable Integer branchId) {
		return branchService.getById(branchId);
	}

	@GetMapping("/allbrach")
	public List<BranchEntity> getAll() {
		return branchService.getAll();
	}

	@PostMapping("/saveprice")
	public PricingEntity savePrice(@RequestBody PricingEntity price) {
		return pricingService.savePrice(price);
	}

	@PutMapping("/updateprice")
	public PricingEntity updatePrice(@PathVariable Integer price) {
		return pricingService.updatePrice(price);
	}

	@GetMapping("/getprice/{priceId}")
	public PricingEntity getByIdPricing(@PathVariable Integer priceId) {
		return pricingService.getById(priceId) ;
	}
	@GetMapping("/allprice")
	public List<PricingEntity> getAllPricing() {
		return pricingService.getAll();
	}
	
	
	
	

}
