package com.lawfirm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.lawfirm.dto.PropertyDTO;
import com.lawfirm.exception.ApiResponse;
import com.lawfirm.exception.ResourceNotFoundException;
import com.lawfirm.service.PropertyService;

import java.util.List;

@RestController
@RequestMapping("/property")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;
 
    @PostMapping("/save")
    public ResponseEntity<ApiResponse<PropertyDTO>> saveProperty(
            @RequestPart("propertyDTO") PropertyDTO propertyDTO,
            @RequestPart("registeredDocumentType") MultipartFile registeredDocumentType) {
        try {
            PropertyDTO savedPropertyDTO = propertyService.saveProperty(propertyDTO, registeredDocumentType);
            return ResponseEntity.ok(new ApiResponse<>("Property saved successfully", savedPropertyDTO, HttpStatus.CREATED.value()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }
    }



    @GetMapping("/{propertyId}")
    public ResponseEntity<ApiResponse<PropertyDTO>> getPropertyById(@PathVariable Long propertyId) {
        try {
            PropertyDTO propertyDTO = propertyService.getPropertyById(propertyId);
            return ResponseEntity.ok(new ApiResponse<>("Property retrieved successfully", propertyDTO, HttpStatus.OK.value()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.NOT_FOUND.value()));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<PropertyDTO>>> getAllProperties() {
        List<PropertyDTO> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(new ApiResponse<>("All properties retrieved successfully", properties, HttpStatus.OK.value()));
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<ApiResponse<PropertyDTO>> updateProperty(
            @PathVariable Long propertyId,
            @RequestParam("propertyDTO") PropertyDTO propertyDTO,
            @RequestParam(value = "registeredDocumentType", required = false) MultipartFile registeredDocumentType) {
        try {
            PropertyDTO updatedProperty = propertyService.updateProperty(propertyId, propertyDTO, registeredDocumentType);
            return ResponseEntity.ok(new ApiResponse<>("Property updated successfully", updatedProperty, HttpStatus.OK.value()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.NOT_FOUND.value()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.BAD_REQUEST.value()));
        }
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<ApiResponse<String>> deleteProperty(@PathVariable Long propertyId) {
        try {
            String message = propertyService.deleteProperty(propertyId);
            return ResponseEntity.ok(new ApiResponse<>(message, null, HttpStatus.OK.value()));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(e.getMessage(), null, HttpStatus.NOT_FOUND.value()));
        }
    }
}
