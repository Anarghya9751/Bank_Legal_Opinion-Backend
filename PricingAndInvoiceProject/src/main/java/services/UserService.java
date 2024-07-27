package services;

import java.util.List;
import java.util.Optional;

import entities.UserEntity;
	
	public interface UserService {

		UserEntity saveUser(UserEntity user);
		
	    Optional<UserEntity> getUserById(Long id);
	    
	    List<UserEntity> getAllUsers();
	    
	    void deleteUser(Long id);
	}

