package com.source.service;


import java.util.List;
import com.source.entity.BranchEntity;


public interface BranchService {
	
	public BranchEntity updateBranch(Integer branchId);
	public BranchEntity getById(Integer branchId);
	public List<BranchEntity> getAll();
	public String deleteById(Integer branchId);
	BranchEntity saveBranch(BranchEntity branch);

	
	


}
