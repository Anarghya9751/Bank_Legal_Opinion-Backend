package com.anarghya.price.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anarghya.price.entity.PricingEntity;
import com.anarghya.price.response.ApiResponse;
import com.anarghya.price.service.PricingServiceImp;

import jakarta.validation.Valid;

@RestController
public class PricingController {
	
	@Autowired
	private PricingServiceImp pricingService;
	
	@PostMapping("/saveprice")
	public ResponseEntity<ApiResponse<PricingEntity>> savePrice(@Valid @RequestBody PricingEntity price) {
		PricingEntity prices = pricingService.savePrice(price);
		return ResponseEntity.ok(new ApiResponse<>("price created sucessfully", prices));
	}
	
	@GetMapping("/{priceId}/total")
    public Long getTotalPrice(@PathVariable Integer priceId) {
        return pricingService.calculateTotalPrice(priceId);
    }
	
//	 @GetMapping("/get/{priceId}")
//	    public ResponseEntity<ApiResponse<PricingEntity>> getPriceById(@PathVariable Integer priceId) {
//	        PricingEntity price = pricingService.getById(priceId);
//	        return ResponseEntity.ok(new ApiResponse<>("Price retrieved successfully", price));
//	    }
//	 @GetMapping("/allprice")
//		public ResponseEntity<ApiResponse<List<PricingEntity>>> getAllPricing() {
//			List<PricingEntity> prices = pricingService.getAll();
//			return ResponseEntity.ok(new ApiResponse<>("All Price retrieved successfully", prices));
//		}
//		
//		 @DeleteMapping("/delete/{priceid}")
//			public ResponseEntity<ApiResponse<String>> deletePricing(@PathVariable Integer priceId) {
//				String status = pricingService.deletePricing(priceId);
//				return ResponseEntity.ok(new ApiResponse<>(status, null));
//			}

}
