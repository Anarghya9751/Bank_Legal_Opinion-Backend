package com.anarghya.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.PricingEntity;
import com.anarghya.bank.exception.IdNotFoundException;
import com.anarghya.bank.repository.PricingRepository;

@Service
public class PricingServiceImp implements PricingService {

    @Autowired
    private PricingRepository pricingRepo;

    @Override
    public PricingEntity savePrice(PricingEntity price) {
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