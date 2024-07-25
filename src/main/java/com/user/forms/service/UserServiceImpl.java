package com.user.forms.service;

import java.util.List;
import java.util.Optional;

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
	public Optional<UserEntity> getById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public UserEntity updateUser(Long id,UserEntity user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public String deleteById(Long id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
		 return "deleted sucessfully";
	}


}
