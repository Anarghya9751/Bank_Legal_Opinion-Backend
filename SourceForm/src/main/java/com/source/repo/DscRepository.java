package com.source.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.source.entity.DscEntity;

public interface DscRepository extends JpaRepository<DscEntity, Long> {
	boolean existsByEmailAndContactNumber( String email, String contactNumber);
}








