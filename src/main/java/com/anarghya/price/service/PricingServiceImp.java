package com.anarghya.price.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.price.entity.PricingEntity;
import com.anarghya.price.exception.IdNotFoundException;
import com.anarghya.price.repository.PricingRepository;

import jakarta.transaction.Transactional;

@Service
public class PricingServiceImp implements PricingService {

    @Autowired
    private PricingRepository pricingRepo;
    

    @Transactional
    public PricingEntity savePrice(PricingEntity price) {
        return pricingRepo.save(price);
    }


	@Override
	 public Double calculateTotalPrice(Integer priceId) {
        PricingEntity pricingEntity = pricingRepo.findById(priceId)
                .orElseThrow(() -> new RuntimeException("Pricing not found for this id :: " + priceId));
        
        return calculateTotal(pricingEntity);
    }

    private Double calculateTotal(PricingEntity pricingEntity) {
        Double total= (pricingEntity.getOpinionFee() != null ? pricingEntity.getOpinionFee() : 0) +
               (pricingEntity.getCaseFee() != null ? pricingEntity.getCaseFee() : 0) +
               (pricingEntity.getNoticeFee() != null ? pricingEntity.getNoticeFee() : 0);
        
        Double gst = total * (pricingEntity.getGst() != null ? pricingEntity.getGst(): 0) /100;
        
        return total+gst;
    }

    
   
    @Override
    public List<PricingEntity> getAll() {
        return pricingRepo.findAll();
    }

    @Override
    public PricingEntity updatePrice(Integer priceId, PricingEntity price) {
        PricingEntity existingPrice = pricingRepo.findById(priceId)
                .orElseThrow(() -> new IdNotFoundException("PricingEntity not found with id: " + priceId));

//        existingPrice.setPriceId(price.getPriceId());  
        existingPrice.setCaseFee(price.getCaseFee());
        existingPrice.setGst(price.getGst());
        existingPrice.setNoticeFee(price.getNoticeFee());
        existingPrice.setOpinionFee(price.getOpinionFee());

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