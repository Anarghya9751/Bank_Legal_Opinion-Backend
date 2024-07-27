package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
}
