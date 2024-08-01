package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.bank.entity.BranchEntity;

import jakarta.validation.Valid;
@Repository
public interface BranchRepository extends JpaRepository<@Valid BranchEntity, Integer> {
	

}
