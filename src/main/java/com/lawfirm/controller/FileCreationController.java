package com.lawfirm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lawfirm.dto.FileCreationDTO;
import com.lawfirm.exception.ApiResponse;
import com.lawfirm.exception.InvalidInputException;
import com.lawfirm.exception.ResourceNotFoundException;
import com.lawfirm.service.FileCreationService;

@RestController
@RequestMapping("/api")
public class FileCreationController {

    @Autowired
    private FileCreationService fileCreationService;

    @PostMapping("/savefile")
    public ResponseEntity<ApiResponse<FileCreationDTO>> createFileCreation(
            @RequestPart("fileCreationDTO") FileCreationDTO fileCreationDTO,
            @RequestPart("documents") MultipartFile documents) {
        try {
            FileCreationDTO createdFile = fileCreationService.createFileCreation(fileCreationDTO, documents);
            return ResponseEntity.ok(new ApiResponse<>("File creation record created successfully", createdFile, HttpStatus.CREATED.value()));
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.BAD_REQUEST.value()));
        }
    }

    @GetMapping("/getfile/{fileId}")
    public ResponseEntity<ApiResponse<FileCreationDTO>> getFileCreationById(@PathVariable Integer fileId) {
        try {
            FileCreationDTO fileCreationDTO = fileCreationService.getFileCreationById(fileId);
            return ResponseEntity.ok(new ApiResponse<>("File creation record retrieved successfully", fileCreationDTO, HttpStatus.OK.value()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.NOT_FOUND.value()));
        }
    }

    @GetMapping("/getallfiles")
    public ResponseEntity<ApiResponse<List<FileCreationDTO>>> getAllFileCreations() {
        List<FileCreationDTO> fileCreations = fileCreationService.getAllFileCreations();
        return ResponseEntity.ok(new ApiResponse<>("All file creation records retrieved successfully", fileCreations, HttpStatus.OK.value()));
    }
    @PutMapping("/updatefile/{fileId}")
    public ResponseEntity<ApiResponse<FileCreationDTO>> updateFileCreation(
            @PathVariable Integer fileId,
            @RequestPart("fileCreationDTO") FileCreationDTO fileCreationDTO,
            @RequestPart("documents") MultipartFile documents) {
        try {
            FileCreationDTO updatedFile = fileCreationService.updateFileCreation(fileId, fileCreationDTO, documents);
            return ResponseEntity.ok(new ApiResponse<>("File creation record updated successfully", updatedFile, HttpStatus.OK.value()));
        } catch (InvalidInputException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.BAD_REQUEST.value()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.NOT_FOUND.value()));
        }
    }

    @DeleteMapping("/deletefile/{fileId}")
    public ResponseEntity<ApiResponse<String>> deleteFileCreation(@PathVariable Integer fileId) {
        try {
            String message = fileCreationService.deleteFileCreation(fileId);
            return ResponseEntity.ok(new ApiResponse<>(message, null, HttpStatus.OK.value()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.NOT_FOUND.value()));
        }
    }
}
