package com.tejaswi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tejaswi.entity.FileCreationEntity;
import com.tejaswi.entity.PropertyDetailsEntity;
import com.tejaswi.response.ApiResponse;
import com.tejaswi.service.FileCreationService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/file")
@CrossOrigin("*")
public class FileCreationController {
	 @Autowired
	    private FileCreationService fileCreationService;
	 
	 @PostMapping("/save")
	    public ResponseEntity<ApiResponse<FileCreationEntity>> saveFile(
	    		@Valid
	    		@RequestParam("entity")String entity,
	            @RequestParam("branch") String branch,
	            @RequestParam("clientName") String clientName,
	            @RequestParam("mobile") String mobile,
	            @RequestParam("address") String address,
	            @RequestParam(value="properties",required = false) List<PropertyDetailsEntity> properties,
	            
	            @RequestParam("documents") MultipartFile documents,
	            @RequestParam("documentName") String documentName,
	            @RequestParam("verifiedStatus") String verifiedStatus) {

	        FileCreationEntity savedFile = fileCreationService.saveFile(entity,branch, clientName, mobile, address,
	                properties, documents, documentName, verifiedStatus);

	        return ResponseEntity.ok(new ApiResponse<>("Created successfully", savedFile));
	    }
	 
	 @PutMapping("/update/{fileId}")
	    public ResponseEntity<ApiResponse<FileCreationEntity>> updateFile(
	            @PathVariable Integer fileId,
	            @Valid
	            @RequestParam("entity")String entity,
	            @RequestParam("branch") String branch,
	            @RequestParam("clientName") String clientName,
	            @RequestParam("mobile") String mobile,
	            @RequestParam("address") String address,
	            @RequestParam(value="properties",required = false) List<PropertyDetailsEntity> properties,
	            @RequestParam("documents") MultipartFile documents,
	            @RequestParam("documentName") String documentName,
	            @RequestParam("verifiedStatus") String verifiedStatus) {

	        FileCreationEntity updatedFile = fileCreationService.updateFile(fileId,entity, branch, clientName, mobile, address,
	                properties, documents, documentName, verifiedStatus);

	        return ResponseEntity.ok(new ApiResponse<>("Update successfully", updatedFile));
	    }

	    @GetMapping("/get/{fileId}")
	    public ResponseEntity<ApiResponse<FileCreationEntity>> getFileById(@PathVariable Integer fileId) {
	        FileCreationEntity file = fileCreationService.getFileById(fileId);
	        if (file != null) {
	            return ResponseEntity.ok(new ApiResponse<>("Retrieved all successfully", file));
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/all")
	    public ResponseEntity<ApiResponse<List<FileCreationEntity>>> getAllFiles() {
	        List<FileCreationEntity> files = fileCreationService.getAllFiles();
	        return ResponseEntity.ok(new ApiResponse<>("Retrieved successfully", files));
	    }

	    @DeleteMapping("/delete/{fileId}")
	    public ResponseEntity<ApiResponse<String>> deleteFileById(@PathVariable Integer fileId) {
	        String result = fileCreationService.deleteFileById(fileId);
	        return ResponseEntity.ok(new ApiResponse<>(result, null));
	    }
}
