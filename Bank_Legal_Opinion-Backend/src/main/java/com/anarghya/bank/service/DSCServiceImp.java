package com.anarghya.bank.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.anarghya.bank.entity.DSCChannel;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.repository.DSCChannelRepository;
import com.anarghya.bank.repository.PricingRepository;

@Service
public class DSCServiceImp implements DSCService {

	@Autowired
	private DSCChannelRepository dscRepo;

	@Autowired
	private PricingRepository pricingRepo;

	
	
	@Override
	public DSCChannel getById(Integer dscid) {
		Optional<DSCChannel> findById = dscRepo.findById(dscid);

		if (findById.isPresent()) {
			return findById.get();
		}
		return null;

	}
	
	
	
	

	@Override
	public List<DSCChannel> getAll() {
		// TODO Auto-generated method stub
		return dscRepo.findAll();
	}

	@Override
	public String deleteById(Integer dscid) {
		// TODO Auto-generated method stub
		dscRepo.deleteById(dscid);
		return "Deleted Successfully";
	}

	@Override
	public DSCChannel saveDSC(DSCChannel dsc, MultipartFile mou) {
		if (mou != null && !mou.isEmpty()) {
			try {
				dsc.setMou(mou.getBytes());
			} catch (IOException e) {
				throw new RuntimeException("Error saving MOU", e);
			}
		}

		// Ensure PricingEntity instances are managed by the persistence context
		List<PricingEntity> managedPricingEntities = new ArrayList<>();
		for (PricingEntity pricing : dsc.getPricing()) {
			if (pricing.getPriceId() != null) {
				// If the PricingEntity has an ID, fetch it from the database
				PricingEntity managedPricing = pricingRepo.findById(pricing.getPriceId())
						.orElseThrow(() -> new RuntimeException("PricingEntity not found: " + pricing.getPriceId()));
				managedPricingEntities.add(managedPricing);
			} else {
				// If it is a new PricingEntity, save it first
				PricingEntity managedPricing = pricingRepo.save(pricing);
				managedPricingEntities.add(managedPricing);
			}
		}
		dsc.setPricing(managedPricingEntities);

		return dscRepo.save(dsc);
	}

	@Override
	public DSCChannel updateDSC(Integer dscid, DSCChannel dscDetails, MultipartFile mou) {
	    DSCChannel dsc = dscRepo.findById(dscid)
	                            .orElseThrow(() -> new RuntimeException("Id not found"));

	    // Update other fields from dscDetails
	    dsc.setDscname(dscDetails.getDscname());
	    dsc.setDirectorname(dscDetails.getDirectorname());
	    dsc.setEmail(dscDetails.getEmail());
	    dsc.setPhnum(dscDetails.getPhnum());
	    dsc.setPricing(dscDetails.getPricing());
	    // Handle MOU file update
	    if (mou != null && !mou.isEmpty()) {
	        try {
	            dsc.setMou(mou.getBytes());
	        } catch (IOException e) {
	            throw new RuntimeException("Error updating MOU", e);
	        }
	    } else {
	        dsc.setMou(dscDetails.getMou());
	    }

	    // Save and return updated DSCChannel
	    return dscRepo.save(dsc);
	}




}
