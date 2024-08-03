package com.anarghya.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.price.entity.DirectBankChannel;


@Repository
public interface DirectBankRepository extends JpaRepository<DirectBankChannel, Integer> {

}
