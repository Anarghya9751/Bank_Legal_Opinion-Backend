package com.lawfirm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawfirm.entity.PropertyDetailsEntity;

public interface PropertyDetailsRepository extends JpaRepository<PropertyDetailsEntity, Long> {

}
