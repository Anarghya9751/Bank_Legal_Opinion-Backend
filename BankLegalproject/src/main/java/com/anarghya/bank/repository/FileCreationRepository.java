package com.anarghya.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anarghya.bank.entity.FileCreationEntity;

@Repository
public interface FileCreationRepository extends JpaRepository<FileCreationEntity, Integer> {

}