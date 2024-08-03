package com.source.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.source.entity.BankEntity;
import com.source.entity.DscEntity;
import com.source.service.DscService;

import java.util.List;

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
}
