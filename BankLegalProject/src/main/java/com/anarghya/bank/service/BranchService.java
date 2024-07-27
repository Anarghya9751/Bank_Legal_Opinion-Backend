package com.anarghya.bank.service;

import java.util.List;

import com.anarghya.bank.entity.BranchEntity;

public interface BranchService {
	
	public BranchEntity saveBranch(BranchEntity branch);
	public BranchEntity updateBranch(Integer branchId);
	public BranchEntity getById(Integer branchId);
	public List<BranchEntity> getAll();
	public String deleteById(Integer branchId);

}
