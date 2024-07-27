package com.tejaswi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.entity.PropertyDetailsEntity;
@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetailsEntity, Long>{

}
