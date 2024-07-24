package com.user.forms.service;

import java.util.List;

import com.user.forms.entity.UserEntity;

public interface UserService {

	//UserEntity findBymail(String mail);
	
	public UserEntity  saveUser(UserEntity user) ;


public UserEntity getById(Long Id);
public List<UserEntity> getAll();
public UserEntity updateUser(Long Id);
public String deleteById(Long Id);

}








