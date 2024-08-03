package com.anarghya.price.service;

import java.util.List;

import com.anarghya.price.entity.PricingEntity;



public interface PricingService {

	public PricingEntity savePrice(PricingEntity price);
	
	public Long calculateTotalPrice(Integer priceId);

//	public PricingEntity updatePrice(Integer priceId, PricingEntity price);
//
//	public PricingEntity getById(Integer priceId);
//
//	public List<PricingEntity> getAll();
//	
//	public String deletePricing(Integer priceId);

}
