package com.source.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.source.entity.DscEntity;
//import com.source.exception.DuplicateDscRecordException;
import com.source.exception.IdNotFoundException;
import com.source.repo.DscRepository;

//import jakarta.transaction.Transactional;
@Service
public class DscServiceImpl implements DscService {
     @Autowired
	private DscRepository repo;
	
	@Override
   public DscEntity saveDsc(DscEntity dscRecord) {
      return repo.save(dscRecord);
    }

	@Override
	public List<DscEntity> getAll() {
		return repo.findAll();
	}

	@Override
	public DscEntity getDscById(Long id) {
		//return repo.findById(id).get();
		return repo.findById(id).orElseThrow(()->new IdNotFoundException("dsc with is  id  not"));
	}



	@Override
    public DscEntity updateDsc(DscEntity dsc, Long id) {
        DscEntity existingDsc = repo.findById(id).orElseThrow(() -> new IdNotFoundException("DSC with id " + id + " not found"));
        existingDsc.setNameofthedsc(dsc.getNameofthedsc());
        existingDsc.setState(dsc.getState());
        existingDsc.setCity(dsc.getCity());
        existingDsc.setArea(dsc.getArea());
        existingDsc.setAuthorizedPersonName(dsc.getAuthorizedPersonName());
        existingDsc.setEmail(dsc.getEmail());
        existingDsc.setContactNumber(dsc.getContactNumber());
        existingDsc.setDate(dsc.getDate());
        return repo.save(existingDsc);
    }
	
	
	
	@Override
	public String deleteDsc(Long id) {
		repo.deleteById(id);
	 return "deleted sucessfully";
	}

}
