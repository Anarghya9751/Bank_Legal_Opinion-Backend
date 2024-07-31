package com.lawfirm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawfirm.entity.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

}
