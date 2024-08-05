package com.source.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.source.entity.BankEntity;


public interface BankRepository extends JpaRepository<BankEntity, Long> {
}

