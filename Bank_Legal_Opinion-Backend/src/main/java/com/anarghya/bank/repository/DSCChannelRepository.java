package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.bank.entity.DSCChannel;

@Repository
public interface DSCChannelRepository extends JpaRepository<DSCChannel, Integer> {

}
