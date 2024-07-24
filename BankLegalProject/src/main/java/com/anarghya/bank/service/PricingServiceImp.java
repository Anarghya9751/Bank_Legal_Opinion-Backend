package com.anarghya.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anarghya.bank.entity.PricingEntity;
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
	public PricingEntity updatePrice(Integer priceId) {
		return pricingRepo.findById(priceId).get();
	}

	@Override
	public PricingEntity getById(Integer priceId) {
		return pricingRepo.findById(priceId).get();
	}

	@Override
	public List<PricingEntity> getAll() {
		return pricingRepo.findAll();
	}

	

}
