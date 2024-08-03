package com.source.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.source.repo.BankRepository;
import com.source.entity.BankEntity;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository repo;

	
	
	@Override
	public BankEntity saveBank(BankEntity bank) {
		return repo.save(bank);
	}

	@Override
	public List<BankEntity> getAll() {
		return repo.findAll();
	}
	
	@Override
    public BankEntity getBankById(Long id) {
        return repo.findById(id).get();
    }
    
	@Override
	public BankEntity updateBank(BankEntity bank, Long id) {
		return repo.save(bank);
	}

	@Override
	public String deleteBank(Long id) {
		 repo.deleteById(id);
		 return "deleted sucessfully";
	

	}

}
