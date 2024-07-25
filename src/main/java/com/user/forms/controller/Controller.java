package com.user.forms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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

	@PutMapping("/update/{id}")
	public UserEntity updateUser( @PathVariable Long id,@Valid @RequestBody UserEntity user) {
		return service.saveUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.deleteById(id);
	}
	
	
	
}


