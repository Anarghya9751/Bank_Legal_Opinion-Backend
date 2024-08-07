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

import com.source.entity.DscEntity;

import com.source.service.DscService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dscs")
public class DscController {

    @Autowired
    private DscService dscService;

   
    @PostMapping("/save")
	public ResponseEntity<ApiResponse<DscEntity>> save(@Valid @RequestBody DscEntity dsc) {
    	DscEntity dscs = dscService.saveDsc(dsc);
		return ResponseEntity.ok(new ApiResponse<>("Dscs Data  Saved sucessfull",dscs));
	}
    
     
    
    @GetMapping("/getAll")
   	public ResponseEntity<ApiResponse<List<DscEntity>>> getAll(@Valid @RequestBody DscEntity dsc) {
   	 List<DscEntity> dscs =dscService.getAll();
   		return ResponseEntity.ok(new ApiResponse<>("ALL Dscs Details Retrived sucessfully", dscs));
   	}
    
    
    

    
    @GetMapping("/{id}")
	public ResponseEntity<ApiResponse<DscEntity>> getDscById(@PathVariable Long id) {
    	DscEntity dscs  =dscService.getDscById(id);
	 return ResponseEntity.ok(new ApiResponse<>(" dscs data retrived sucessfully", dscs));
	}
    

    
    
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<DscEntity>> update(@Valid @RequestBody  DscEntity dsc, @PathVariable Long id) {
    	DscEntity dscs = dscService.saveDsc(dsc);
        return ResponseEntity.ok(new ApiResponse<>("Dsc data updated successfully",dscs));
    }

    
    
    @DeleteMapping("/{id}")
    public String deleteDsc(@PathVariable Long id) {
      return dscService.deleteDsc(id);
    }
}
    
    


