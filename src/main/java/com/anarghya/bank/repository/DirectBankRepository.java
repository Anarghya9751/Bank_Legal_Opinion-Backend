package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.bank.entity.DirectBankChannel;

@Repository
public interface DirectBankRepository extends JpaRepository<DirectBankChannel, Integer> {

}
