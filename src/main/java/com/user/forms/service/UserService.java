package com.user.forms.service;

import java.util.List;
import java.util.Optional;

import com.user.forms.entity.UserEntity;

public interface UserService {

	//UserEntity findBymail(String mail);
	
	public UserEntity  saveUser(UserEntity user) ;


public Optional<UserEntity> getById(Long id);
public List<UserEntity> getAll();
public UserEntity updateUser(Long id,UserEntity user);
public String deleteById(Long id);

}








