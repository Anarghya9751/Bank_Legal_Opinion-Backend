package com.clientinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientinfo.entity.ClientInfoEntity;

public interface ClientInfoRepository  extends JpaRepository<ClientInfoEntity , Long>{


}
