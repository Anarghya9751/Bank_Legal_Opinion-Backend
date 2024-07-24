package com.anarghya.bank.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anarghya.bank.entity.DSCChannel;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.repository.DSCChannelRepository;

@Service
public class DSCServiceImp implements DSCService {

	@Autowired
	private DSCChannelRepository dscRepo;
	


	@Override
	public DSCChannel getById(Integer dscid) {
		return dscRepo.findById(dscid).get();
	}

	@Override
	public List<DSCChannel> getAll() {
		// TODO Auto-generated method stub
		return dscRepo.findAll();
	}

	@Override
	public DSCChannel updateDSC(Integer dscid) {
		// TODO Auto-generated method stub
		return dscRepo.findById(dscid).get();
	}

	@Override
	public String deleteById(Integer dscid) {
		// TODO Auto-generated method stub
		dscRepo.deleteById(dscid);
		return "Deleted Successfully";
	}

	@Override
	public DSCChannel saveDSC(MultipartFile mou, Integer dscid, String dscname, String directorname, Long phnum,
			String email,List<PricingEntity> pricing) {
		// TODO Auto-generated method stub
		
		DSCChannel dsc=new DSCChannel();
		dsc.setDscid(dscid);
		dsc.setDscname(dscname);
		dsc.setDirectorname(directorname);
		dsc.setEmail(email);
		dsc.setPhnum(phnum);
		dsc.setPricing(pricing);
		
		try {
            if (mou != null && !mou.isEmpty()) {
                String base64String = Base64.getEncoder().encodeToString(mou.getBytes());
                dsc.setMou(base64String);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return dscRepo.save(dsc);
	}

}
