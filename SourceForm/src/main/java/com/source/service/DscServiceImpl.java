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
	//@Transactional
   public DscEntity saveDsc(DscEntity dscRecord) {
     //   boolean exists = repo.existsByEmailAndContactNumber(
       //         dscRecord.getEmail(),
         //       dscRecord.getContactNumber()
        //);

       // if (exists) {
       //     throw new DuplicateDscRecordException("A record with the same contact number and email details already exists.");
     //   }

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
	 return repo.save(dsc);
	}

	@Override
	public String deleteDsc(Long id) {
		repo.deleteById(id);
	 return "deleted sucessfully";
	}

}
