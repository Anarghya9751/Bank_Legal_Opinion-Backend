package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.UserEntity;
import services.UserService;

	
	@RestController
	@RequestMapping("/api/users")
	public class UserController {

	    @Autowired
	    private UserService userService;

	    @PostMapping
	    public UserEntity createUser(@RequestBody UserEntity user) {
	        return userService.saveUser(user);
	    }

	    @GetMapping
	    public List<UserEntity> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping("/{id}")
	    public Optional<UserEntity> getUserById(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }
	
	
	}
