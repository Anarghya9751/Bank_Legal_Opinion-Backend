package com.anarghya.bank.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.anarghya.bank.entity.BranchEntity;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.response.ApiResponse;
import com.anarghya.bank.service.BranchServiceImp;
import com.anarghya.bank.service.PricingServiceImp;

import jakarta.validation.Valid;

@RestController
public class BranchAndPricingController {

	@Autowired
	private BranchServiceImp branchService;
	@Autowired
	private PricingServiceImp pricingService;
	
	 @PostMapping("/saveprice")
	 public ResponseEntity<PricingEntity> createOrUpdatePrice(@Valid @RequestBody PricingEntity pricingEntity) {
	        PricingEntity savedPrice = pricingService.savePrice(pricingEntity);
	        return new ResponseEntity<>(savedPrice, HttpStatus.OK);
	    }
	 
//	 @PostMapping("/savebranch")
//	    public ResponseEntity<?> saveBranch(@Valid @RequestBody BranchEntity branch, BindingResult bindingResult) {
////	        if (bindingResult.hasErrors()) {
//	            String errors = bindingResult.getAllErrors().stream()
//	                .map(error -> error.getDefaultMessage())
//	                .collect(Collectors.joining(", "));
//	            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//	        }
//
//	        try {
//	            BranchEntity savedBranch = branchService.saveBranch(branch);
//	            return new ResponseEntity<>(savedBranch, HttpStatus.CREATED);
//	        } catch (Exception e) {
//	            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	        }
//		 try {
//	            // Handle the creation logic
//	            if ((branch.getBranchName() == null)||(branch.getIfscCode()==null)||(branch.getAddress()==null)) {
//	                throw new NullPointerException("branch field cannot be null");
//	            }
//	            return ResponseEntity.ok("branch created successfully");
//	        } catch (NullPointerException ex) {
//	            // Return a custom error response
//	            return new ResponseEntity<>("Error: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
//	        }
//		 
//	    }

	@PostMapping("/savebranch")
        public ResponseEntity<ApiResponse<BranchEntity>> saveBranch(@Valid @RequestBody BranchEntity branch) {
		BranchEntity branchs=branchService.saveBranch(branch);
		return ResponseEntity.ok(new ApiResponse<>("branch created sucessfully", branchs));
	}
//	@PostMapping("/savebranch")
//	public ResponseEntity<BranchEntity> saveBank( @RequestBody BranchEntity branch) {
////		ApiResponse apiresp = new ApiResponse();
//        try {
//            // Check if any critical field is null
//            if (branch.getBranchName() == null || branch.getAddress() == null || branch.getIfscCode() == null) {
//                throw new NullPointerException("Critical fields are missing in the request");
//            }
//            BranchEntity savedBank = branchService.saveBranch(branch);
//            return new ResponseEntity<>(savedBank, HttpStatus.CREATED);
//        } catch (NullPointerException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
	
//	@PostMapping
//	public ResponseEntity<ApiResponse> saveBranch(@RequestBody BranchEntity branch) {
//		
//		ApiResponse apiresp = new ApiResponse();
//			Student createStudent;
//			try {
//				createStudent = branchService.saveBranch(branch);
//				apiresp.setStatus("Success");
//				apiresp.setErrorcode("200");
//				apiresp.setResponse(createStudent);
//			} catch (IdNotFoundException e) {
//				apiresp.setStatus("Failure");
//				apiresp.setErrorcode("400");
//				apiresp.setResponse("FirstName Can not be Null");
//				return new ResponseEntity<>(apiresp,HttpStatus.BAD_REQUEST);
//			} catch (UnderAgeException e) {
//				apiresp.setStatus("Failure");
//				apiresp.setErrorcode("400");
//				apiresp.setResponse("person should have 18 years of age");
//				return new ResponseEntity<>(apiresp,HttpStatus.BAD_REQUEST);
//			}
//			
//			return new ResponseEntity<>(apiresp,HttpStatus.CREATED);
//		
//	}
	


	@PutMapping("/updatebranch/{branchId}")
	public ResponseEntity<ApiResponse<BranchEntity>> updateBranch(@PathVariable Integer branchId) {
		BranchEntity branch = branchService.updateBranch(branchId);
		return ResponseEntity.ok(new ApiResponse<>("branch Update sucessfully", branch));
	}

	@GetMapping("/getbranch/{branchId}")
	public ResponseEntity<ApiResponse<BranchEntity>> getById(@PathVariable Integer branchId) {
		BranchEntity branch = branchService.getById(branchId);
		return ResponseEntity.ok(new ApiResponse<>("Branch retrieved successfully", branch));
	}

	@GetMapping("/allbrach")
	public ResponseEntity<ApiResponse<List<BranchEntity>>> getAll() {
		List<BranchEntity> branch = branchService.getAll();
		return ResponseEntity.ok(new ApiResponse<>("All Branchs retrieved successfully", branch));
	}

	
	
	 @PutMapping("/update/{priceId}")
	    public ResponseEntity<ApiResponse<PricingEntity>> updatePrice(@PathVariable Integer priceId,@Valid @RequestBody PricingEntity price) {
	        PricingEntity updatedPrice = pricingService.updatePrice(priceId, price);
	        return ResponseEntity.ok(new ApiResponse<>("branch Update sucessfully", updatedPrice));
	    }
	 
	 
	 @DeleteMapping("/delete/{branchId}")
		public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Integer branchId) {
			String status = branchService.deleteById(branchId);
			return ResponseEntity.ok(new ApiResponse<>(status, null));
		}


	    @GetMapping("/get/{priceId}")
	    public ResponseEntity<ApiResponse<PricingEntity>> getPriceById(@PathVariable Integer priceId) {
	        PricingEntity price = pricingService.getById(priceId);
	        return ResponseEntity.ok(new ApiResponse<>("Price retrieved successfully", price));
	    }

	    
	    
	@PostMapping("/savePrice")
	public ResponseEntity<ApiResponse<PricingEntity>> savePricing(@Valid @RequestBody PricingEntity price) {
		PricingEntity prices = pricingService.savePrice(price);
		return ResponseEntity.ok(new ApiResponse<>("price created sucessfully", prices));
	}

	@GetMapping("/allprice")
	public ResponseEntity<ApiResponse<List<PricingEntity>>> getAllPricing() {
		List<PricingEntity> prices = pricingService.getAll();
		return ResponseEntity.ok(new ApiResponse<>("All Price retrieved successfully", prices));
	}
	
	 @DeleteMapping("/delete/{priceid}")
		public ResponseEntity<ApiResponse<String>> deletePricing(@PathVariable Integer priceId) {
			String status = branchService.deleteById(priceId);
			return ResponseEntity.ok(new ApiResponse<>(status, null));
		}

}
