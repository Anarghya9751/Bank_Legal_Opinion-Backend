package com.anarghya.bank.controller;

import com.anarghya.bank.entity.FileCreationEntity;
import com.anarghya.bank.entity.PropertyDetailsEntity;
import com.anarghya.bank.service.FileCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/file")
@CrossOrigin("*")
public class FileCreationController {

    @Autowired
    private FileCreationService fileCreationService;
    
    
    @PostMapping("/save")
    public ResponseEntity<FileCreationEntity> saveFile(
            @RequestParam("branch") String branch,
            @RequestParam("clientName") String clientName,
            @RequestParam("mobile") Long mobile,
            @RequestParam("address") String address,
            @RequestParam(value="properties",required = false) List<PropertyDetailsEntity> properties,
            
            @RequestParam("documents") MultipartFile documents,
            @RequestParam("documentName") String documentName,
            @RequestParam("verifiedStatus") String verifiedStatus) {

        FileCreationEntity savedFile = fileCreationService.saveFile(branch, clientName, mobile, address,
                properties, documents, documentName, verifiedStatus);

        return new ResponseEntity<>(savedFile, HttpStatus.CREATED);
    }
    @PutMapping("/update/{fileId}")
    public ResponseEntity<FileCreationEntity> updateFile(
            @PathVariable Integer fileId,
            @RequestParam("branch") String branch,
            @RequestParam("clientName") String clientName,
            @RequestParam("mobile") Long mobile,
            @RequestParam("address") String address,
            @RequestParam(value="properties",required = false) List<PropertyDetailsEntity> properties,
            @RequestParam("documents") MultipartFile documents,
            @RequestParam("documentName") String documentName,
            @RequestParam("verifiedStatus") String verifiedStatus) {

        FileCreationEntity updatedFile = fileCreationService.updateFile(fileId, branch, clientName, mobile, address,
                properties, documents, documentName, verifiedStatus);

        return new ResponseEntity<>(updatedFile, HttpStatus.OK);
    }

    @GetMapping("/get/{fileId}")
    public ResponseEntity<FileCreationEntity> getFileById(@PathVariable Integer fileId) {
        FileCreationEntity file = fileCreationService.getFileById(fileId);
        if (file != null) {
            return new ResponseEntity<>(file, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<FileCreationEntity>> getAllFiles() {
        List<FileCreationEntity> files = fileCreationService.getAllFiles();
        return new ResponseEntity<>(files, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{fileId}")
    public ResponseEntity<String> deleteFileById(@PathVariable Integer fileId) {
        String result = fileCreationService.deleteFileById(fileId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
