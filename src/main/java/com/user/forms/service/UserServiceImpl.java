package com.user.forms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.forms.entity.UserEntity;
import com.user.forms.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserEntity saveUser(UserEntity user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}
	
	

	@Override
	public UserEntity getById(Long Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id).get();
	}

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public UserEntity updateUser(Long Id) {
		// TODO Auto-generated method stub
		return repo.findById(Id).get()  ;
	}

	@Override
	public String deleteById(Long Id) {
		// TODO Auto-generated method stub
		 repo.deleteById(Id);
		 return "deleted sucessfully";
	}


}
