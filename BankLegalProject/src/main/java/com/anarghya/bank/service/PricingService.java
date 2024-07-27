package com.anarghya.bank.service;

import java.util.List;

import com.anarghya.bank.entity.PricingEntity;

public interface PricingService {

	public PricingEntity savePrice(PricingEntity price);

	public PricingEntity updatePrice(Integer priceId, PricingEntity price);

	public PricingEntity getById(Integer priceId);

	public List<PricingEntity> getAll();
	
	public String deletePricing(Integer priceId);

}
