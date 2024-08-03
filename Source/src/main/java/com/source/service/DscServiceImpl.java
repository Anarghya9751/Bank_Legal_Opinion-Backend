package com.source.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.entity.DscEntity;
import com.source.repo.DscRepository;
@Service
public class DscServiceImpl implements DscService {
     @Autowired
	private DscRepository repo;
	
	@Override
	public DscEntity saveDsc(DscEntity dsc) {
		return repo.save(dsc) ;
	}

	@Override
	public List<DscEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public DscEntity getDscById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public DscEntity updateDsc(DscEntity dsc, Long id) {
	 return repo.save(dsc);
	}

	@Override
	public String deleteDsc(Long id) {
		repo.deleteById(id);
	 return "deleted sucessfully";
	}

}
