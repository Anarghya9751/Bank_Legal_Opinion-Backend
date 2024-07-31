package com.lawfirm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawfirm.entity.FileCreationEntity;

public interface FileCreationRepository extends JpaRepository<FileCreationEntity, Integer> {

}
