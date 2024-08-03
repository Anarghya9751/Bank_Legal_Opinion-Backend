package com.source.service;


import java.util.List;
import java.util.Optional;

import com.source.entity.BankEntity;



public interface BankService {
	
public BankEntity saveBank(BankEntity bank);
public List<BankEntity> getAll();
public BankEntity getBankById(Long id);
public BankEntity updateBank(BankEntity bank, Long id);
public String deleteBank(Long id);
}





