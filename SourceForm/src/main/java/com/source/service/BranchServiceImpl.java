package com.source.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.entity.BranchEntity;
import com.source.exception.IdNotFoundException;
import com.source.repo.BranchRepo;


@Service
public class BranchServiceImpl implements BranchService {
	
	@Autowired
	private BranchRepo branchRepo;

	@Override
	public BranchEntity saveBranch(BranchEntity branch) {
		 
		return branchRepo.save(branch);
	}

	@Override	
	public BranchEntity updateBranch(Integer branchId) {
		return branchRepo.findById(branchId).get();
	}


	@Override
	public BranchEntity getById(Integer branchId) {
		return branchRepo.findById(branchId).orElseThrow(()-> new IdNotFoundException(" User Not Found With Id : " +branchId));

		}

	@Override
	public List<BranchEntity> getAll() {
		return branchRepo.findAll();
	}

	@Override
	public String deleteById(Integer branchId) {
		// TODO Auto-generated method stub
		if (branchRepo.existsById(branchId)) {
			branchRepo.deleteById(branchId);
			return "Deleted Successfully";
		}
		return "No User Found";
	}
	
   
    

	

}
