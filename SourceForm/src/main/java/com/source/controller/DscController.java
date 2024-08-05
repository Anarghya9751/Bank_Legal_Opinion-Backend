package com.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.source.entity.DscEntity;
//import com.source.exception.DuplicateDscRecordException;
import com.source.service.DscService;

@RestController
@RequestMapping("/api/dscs")
public class DscController {

    @Autowired
    private DscService dscService;

    @PostMapping("/save")
    public ResponseEntity<DscEntity> createDsc(@Validated @RequestBody DscEntity dsc) {
        return ResponseEntity.ok(dscService.saveDsc(dsc));
    }

    @GetMapping("/getAll")
    public List<DscEntity> getAllDscs() {
        return dscService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DscEntity> getDscById(@PathVariable Long id) {
        return ResponseEntity.ok(dscService.getDscById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DscEntity> updateDsc(@Validated @RequestBody DscEntity dsc, @PathVariable Long id) {
        return ResponseEntity.ok(dscService.updateDsc(dsc, id));
    }

    @DeleteMapping("/{id}")
    public String deleteDsc(@PathVariable Long id) {
      return dscService.deleteDsc(id);
    }
    
  //  @ExceptionHandler(DuplicateDscRecordException.class)
    //public ResponseEntity<String> handleDuplicateDscRecordException(DuplicateDscRecordException ex) {
      //  return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    //}
}

