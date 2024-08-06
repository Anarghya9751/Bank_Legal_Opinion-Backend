 package com.source.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.source.repo.BankRepository;
import com.source.entity.BankEntity;
import com.source.exception.IdNotFoundException;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private BankRepository repo;

		
	@Override
	public BankEntity saveBank(BankEntity bank) {
	return	repo.save(bank);
	
	}

	@Override
	public List<BankEntity> getAll() {
		return repo.findAll();
	}
	
	@Override
    public BankEntity getBankById(Long id) {
        return repo.findById(id).orElseThrow(()->new IdNotFoundException("bank with is id  not"));
    }
    
	@Override
	public BankEntity updateBank(BankEntity bank, Long id) {
	    BankEntity existingBank = repo.findById(id).orElseThrow(() -> new IdNotFoundException("Bank with id " + id + " not found"));
	    existingBank.setBankName(bank.getBankName());
	    existingBank.setState(bank.getState());
	    existingBank.setCity(bank.getCity());
	    existingBank.setBranchName(bank.getBranchName());
	    existingBank.setBranchId(bank.getBranchId());
	    existingBank.setBranchManagerName(bank.getBranchManagerName());
	    existingBank.setMailid(bank.getMailid());
	    existingBank.setContactNumber(bank.getContactNumber());
	    existingBank.setDate(bank.getDate());
	    return repo.save(existingBank);
	}


	@Override
	public String deleteBank(Long id) {
		 repo.deleteById(id);
		 return "deleted sucessfully";
	

	}

}

