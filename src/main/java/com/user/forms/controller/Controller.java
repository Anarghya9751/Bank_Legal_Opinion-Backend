package com.user.forms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.forms.entity.UserEntity;
import com.user.forms.service.UserServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin(origins= "*")
@RestController
public class Controller {
	@Autowired
	private  UserServiceImpl  service;
	
	
	@PostMapping("/save")
	public UserEntity saveUser(@Valid @RequestBody UserEntity  user) {
		return service.saveUser(user);
	}
	
	
	@GetMapping("/get/{id}")
	public Optional<UserEntity> getById(@PathVariable Long id) {
		
		return service.getById(id);
	}
	
	@GetMapping("/getAlluser")
	public List<UserEntity> getAll() {
		
		return service.getAll();
	}

//	@PutMapping("/update/{id}")
//	public UserEntity updateUser( @PathVariable Long id,@Valid @RequestBody UserEntity user) {
//		return service.saveUser(user);
//	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody @Valid UserEntity user) {
	    try {
	        UserEntity existingUser = service.getById(id)
	                .orElseThrow();

	        // Check for unique constraint violations
	        if (!existingUser.getMail().equals(user.getMail())) {
	            boolean emailExists = service.existsByMail(user.getMail());
	            if (emailExists) {
	                return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists.");
	            }
	        }

	        existingUser.setFirstName(user.getFirstName());
	        existingUser.setLastName(user.getLastName());
	        existingUser.setMail(user.getMail());
	        existingUser.setPhoneNumber(user.getPhoneNumber());
	        existingUser.setAddress(user.getAddress());

	        UserEntity updatedUser = service.saveUser(existingUser);
	        return ResponseEntity.ok(updatedUser);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
	    }
	}

	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	
	
}


