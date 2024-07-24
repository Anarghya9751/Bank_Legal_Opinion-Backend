package com.anarghya.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.DirectBankChannel;
import com.anarghya.bank.repository.DirectBankRepository;

@Service
public class DirectBankServiceImp implements DirectBankService {

	
	@Autowired
	private DirectBankRepository bankRepo;
	
	@Override
	public DirectBankChannel saveBank(DirectBankChannel bank) {
		// TODO Auto-generated method stub
		return bankRepo.save(bank);
	}

	@Override
	public DirectBankChannel getById(Integer bankid) {
		// TODO Auto-generated method stub
		return bankRepo.findById(bankid).get();
	}

	@Override
	public List<DirectBankChannel> getAll() {
		// TODO Auto-generated method stub
		return bankRepo.findAll();
	}

	@Override
	public DirectBankChannel updateBank(Integer bankid) {
		// TODO Auto-generated method stub
		return bankRepo.findById(bankid).get();
	}

	@Override
	public String deleteById(Integer bankid) {
		// TODO Auto-generated method stub
		bankRepo.deleteById(bankid);
		return "Delete Successfully";
	}

	
	
}
