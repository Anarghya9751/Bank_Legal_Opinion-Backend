package com.anarghya.price.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.price.entity.DSCChannel;


@Repository
public interface DSCChannelRepository extends JpaRepository<DSCChannel, Integer> {

}
