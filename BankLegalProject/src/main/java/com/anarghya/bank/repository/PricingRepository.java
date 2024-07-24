package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.bank.entity.PricingEntity;

public interface PricingRepository extends JpaRepository<PricingEntity, Integer> {

}
