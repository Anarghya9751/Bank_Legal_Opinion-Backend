package com.anarghya.price.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anarghya.price.entity.DSCChannel;
import com.anarghya.price.repository.DSCChannelRepository;


@Service
public class DSCServiceImp implements DSCService {

	@Autowired
	private DSCChannelRepository dscRepo;

	
	@Override
	public DSCChannel saveDSC(DSCChannel dsc, MultipartFile mou) {
		if (mou != null && !mou.isEmpty()) {
			try {
				dsc.setMou(mou.getBytes());
			} catch (IOException e) {
				throw new RuntimeException("Error saving MOU", e);
			}
		}

		return dscRepo.save(dsc);
	}

//	@Override
//	public DSCChannel getById(Integer dscid) {
//		Optional<DSCChannel> findById = dscRepo.findById(dscid);
//
//		if (findById.isPresent()) {
//			return findById.get();
//		}
//		return null;
//
//	}
//
//	@Override
//	public List<DSCChannel> getAll() {
//		// TODO Auto-generated method stub
//		return dscRepo.findAll();
//	}
//
//	@Override
//	public String deleteById(Integer dscid) {
//		// TODO Auto-generated method stub
//		dscRepo.deleteById(dscid);
//		return "Deleted Successfully";
//	}
//

//	@Override
//	public DSCChannel updateDSC(Integer dscid, DSCChannel dscDetails, MultipartFile mou) {
//		DSCChannel dsc = dscRepo.findById(dscid).orElseThrow(() -> new RuntimeException("Id not found"));
//
//		
//		dsc.setDscname(dscDetails.getDscname());
//		dsc.setDirectorname(dscDetails.getDirectorname());
//		dsc.setEmail(dscDetails.getEmail());
//		dsc.setPhnum(dscDetails.getPhnum());
//		dsc.setPricing(dscDetails.getPricing());
//		if (mou != null && !mou.isEmpty()) {
//			try {
//				dsc.setMou(mou.getBytes());
//			} catch (IOException e) {
//				throw new RuntimeException("Error updating MOU", e);
//			}
//		} else {
//			dsc.setMou(dscDetails.getMou());
//		}
//
//		return dscRepo.save(dsc);
//	}

}
