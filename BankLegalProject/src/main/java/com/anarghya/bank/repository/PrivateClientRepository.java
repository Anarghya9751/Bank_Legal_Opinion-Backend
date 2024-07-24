package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.bank.entity.PrivateClientChannel;

@Repository
public interface PrivateClientRepository extends JpaRepository<PrivateClientChannel, Integer> {

}
