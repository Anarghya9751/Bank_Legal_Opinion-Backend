package com.anarghya.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.price.entity.PricingEntity;


public interface PricingRepository extends JpaRepository<PricingEntity, Integer> {

	

	
}
