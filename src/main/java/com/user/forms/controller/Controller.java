package com.user.forms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.forms.entity.UserEntity;
import com.user.forms.service.UserServiceImpl;

@RestController
public class Controller {
	@Autowired
	private  UserServiceImpl  service;
	
	
	@PostMapping("/save")
	public UserEntity saveUser(@RequestBody UserEntity  user) {
		return service.saveUser(user);
	}
	
	
	@GetMapping("/get/{id}")
	public UserEntity getById(Long id) {
		
		return service.getById(id);
	}
	
	@GetMapping("/getAlluser")
	public List<UserEntity> getAll() {
		
		return service.getAll();
	}

	@PutMapping("/update/{id}")
	public UserEntity updateUser(Long id) {
		return service.updateUser(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(Long id) {
		return service.deleteById(id);
	}
	
	
	
}


