package com.anarghya.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.DSCChannel;
import com.anarghya.bank.entity.DirectBankChannel;
import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.exception.IdNotFoundException;
import com.anarghya.bank.repository.DSCChannelRepository;
import com.anarghya.bank.repository.DirectBankRepository;
import com.anarghya.bank.repository.PricingRepository;

import jakarta.transaction.Transactional;

@Service
public class PricingServiceImp implements PricingService {

    @Autowired
    private PricingRepository pricingRepo;
    
    @Autowired
    private DirectBankRepository dbcRepo;

    @Autowired
    private DSCChannelRepository dscRepo;

    @Transactional
    public PricingEntity savePrice(PricingEntity price) {
        // Check if DirectBankChannel exists and set it in the PricingEntity
        if (price.getDirectbank() != null && price.getDirectbank().getBankId() != null) {
            DirectBankChannel directBankChannel = dbcRepo.findById(price.getDirectbank().getBankId())
                    .orElseThrow(() -> new IllegalArgumentException("DirectBankChannel with id " + price.getDirectbank().getBankId() + " not found"));
            price.setDirectbank(directBankChannel);
        }

        // Check if DSCChannel exists and set it in the PricingEntity
        if (price.getDsc() != null && price.getDsc().getDscid() != null) {
            DSCChannel dscChannel = dscRepo.findById(price.getDsc().getDscid())
                    .orElseThrow(() -> new IllegalArgumentException("DSCChannel with id " + price.getDsc().getDscid() + " not found"));
            price.setDsc(dscChannel);
        }

        // Save and return the PricingEntity
        return pricingRepo.save(price);
    }


    @Override
    public List<PricingEntity> getAll() {
        return pricingRepo.findAll();
    }

    @Override
    public PricingEntity updatePrice(Integer priceId, PricingEntity price) {
        PricingEntity existingPrice = pricingRepo.findById(priceId)
                .orElseThrow(() -> new IdNotFoundException("PricingEntity not found with id: " + priceId));

        // Update fields
        existingPrice.setPriceId(price.getPriceId());  // Assuming priceId can be updated
        // Update other fields as necessary

        return pricingRepo.save(existingPrice);
    }

    @Override
    public PricingEntity getById(Integer priceId) {
        return pricingRepo.findById(priceId)
                .orElseThrow(() -> new IdNotFoundException("PricingEntity not found with id: " + priceId));
    }

	@Override
	public String deletePricing(Integer priceId) {
		if (pricingRepo.existsById(priceId)) {
			pricingRepo.deleteById(priceId);
			return "Deleted Successfully";
		}
		return "No User Found";
		// TODO Auto-generated method stub
		
	}
}