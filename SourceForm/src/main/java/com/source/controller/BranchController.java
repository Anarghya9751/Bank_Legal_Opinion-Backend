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
import com.source.entity.BranchEntity;
import com.source.service.BranchServiceImpl;

import jakarta.validation.Valid;
@RequestMapping("/api/branch")
@RestController
public class BranchController {

	@Autowired
	private BranchServiceImpl branchService;
	

	@PostMapping("/save")
        public ResponseEntity<ApiResponse<BranchEntity>> saveBranch(@Valid @RequestBody BranchEntity branch) {
		BranchEntity branchs=branchService.saveBranch(branch);
		return ResponseEntity.ok(new ApiResponse<>("branch created sucessfully", branchs));
	}

	@PutMapping("/{Id}")
	public ResponseEntity<ApiResponse<BranchEntity>> updateBranch(@PathVariable Integer branchId) {
		BranchEntity branch = branchService.updateBranch(branchId);
		return ResponseEntity.ok(new ApiResponse<>("branch Update sucessfully", branch));
	}

	@GetMapping("/{Id}")
	public ResponseEntity<ApiResponse<BranchEntity>> getById(@PathVariable Integer branchId) {
		BranchEntity branch = branchService.getById(branchId);
		return ResponseEntity.ok(new ApiResponse<>("Branch retrieved successfully", branch));
	}

	@GetMapping("/getAll")
	public ResponseEntity<ApiResponse<List<BranchEntity>>> getAll() {
		List<BranchEntity> branch = branchService.getAll();
		return ResponseEntity.ok(new ApiResponse<>("All Branchs retrieved successfully", branch));
	}

	 
	 @DeleteMapping("/{Id}")
		public ResponseEntity<ApiResponse<String>> deleteById(@PathVariable Integer branchId) {
			String status = branchService.deleteById(branchId);
			return ResponseEntity.ok(new ApiResponse<>(status, null));
		}


}
