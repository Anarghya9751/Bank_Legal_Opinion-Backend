package com.tejaswi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.entity.FileCreationEntity;
@Repository
public interface FileCreationRepository extends JpaRepository<FileCreationEntity, Integer> {

}
