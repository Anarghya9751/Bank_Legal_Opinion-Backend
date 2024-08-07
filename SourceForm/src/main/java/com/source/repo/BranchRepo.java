package com.source.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.source.entity.BranchEntity;

public interface BranchRepo extends JpaRepository<BranchEntity, Integer> {

}
