package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anarghya.bank.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, Integer> {

}
