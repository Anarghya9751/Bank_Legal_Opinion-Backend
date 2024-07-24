package com.anarghya.bank.service;

import java.util.List;

import com.anarghya.bank.entity.DirectBankChannel;

public interface DirectBankService {

	public DirectBankChannel saveBank(DirectBankChannel bank);
	public DirectBankChannel getById(Integer bankid);
	public List<DirectBankChannel> getAll();
	public DirectBankChannel updateBank(Integer bankid);
	public String deleteById(Integer bankid);
}
